package netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    private static final EventExecutorGroup group = new DefaultEventExecutorGroup(16);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Runnable scheduleRunnable = () -> {
            log.info("延时任务执行。。。");
            log.info("执行一个延时任务，线程=" + Thread.currentThread().getName());
        };
        Runnable longTimeRunnable = () -> {
            log.info("执行一个耗时很长的任务，线程=" + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 1000);
                log.info("耗时很长的任务执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info("发生异常");
            }
        };

        // 假如有一个耗时很长的工作，则需要异步执行，提交到任务队列中，这是放到taskQueue
        //group使用线程池，不和当前任务队列共用线程
        group.schedule(scheduleRunnable, 5, TimeUnit.SECONDS);
        group.execute(scheduleRunnable);
        group.submit(() -> {
            log.info("submit 任务");
            Thread.sleep(5000);
            log.info("submit 任务返回");
            return "123";
        }).addListener((e) -> {
            log.info("submit任务返回：" + e.get());
        });
        //ctx这种实现方式和任务队列共用线程，可能阻塞队列
        ctx.channel().eventLoop().schedule(scheduleRunnable, 5, TimeUnit.SECONDS);
        ctx.channel().eventLoop().execute(longTimeRunnable);


        log.info("channel=" + ctx.channel());
        log.info("服务器读取线程：" + Thread.currentThread().getName());
        log.info("server ctx=" + ctx);
        log.info("看看channel和pipeline的关系");
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline(); // pipeline本质是一个双向链表
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("客户端发送消息是：" + byteBuf.toString(CharsetUtil.UTF_8));
        log.info("客户端地址：" + channel.remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 将数据写入缓冲并刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端...", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
