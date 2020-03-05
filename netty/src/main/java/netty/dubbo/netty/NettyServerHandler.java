package netty.dubbo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import netty.dubbo.provider.HelloServiceImpl;
import netty.tcpprotocol.MessageProtocol;

public class NettyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("有连接");
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        if (msg.toString().startsWith("HelloService#hello#")) {
//            String result = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
//            ctx.writeAndFlush(result);
//        } else {
//            System.out.println("调用不存在的方法");
//        }
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol message) throws Exception {
        String msg = new String(message.getContent(), CharsetUtil.UTF_8);
        if (msg.startsWith("HelloService#hello#")) {
            String result = new HelloServiceImpl().hello(msg.substring(msg.lastIndexOf("#") + 1));
            byte[] bytes = result.getBytes(CharsetUtil.UTF_8);
            ctx.writeAndFlush(new MessageProtocol(bytes.length, bytes));
        } else {
            System.out.println("调用不存在的方法");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
