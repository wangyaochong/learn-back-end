package netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 假如有一个耗时很长的工作，则需要异步执行，提交到任务队列中，这是放到taskQueue
        ctx.channel().eventLoop().schedule(() -> {
            System.out.println("延时任务执行。。。");
        }, 5, TimeUnit.SECONDS);
        ctx.channel().eventLoop().execute(() -> {
            System.out.println("执行一个耗时很长的任务");
            try {
                Thread.sleep(10 * 1000);
                System.out.println("耗时很长的任务执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("发生异常");
            }
        });

        System.out.println("channel=" + ctx.channel());
        System.out.println("服务器读取线程：" + Thread.currentThread().getName());
        System.out.println("server ctx=" + ctx);
        System.out.println("看看channel和pipeline的关系");
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline(); // pipeline本质是一个双向链表
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端发送消息是：" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址：" + channel.remoteAddress());
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
