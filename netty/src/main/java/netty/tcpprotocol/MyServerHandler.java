package netty.tcpprotocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        String message = new String(msg.getContent(), CharsetUtil.UTF_8);
        System.out.println("服务器接受到数据=" + message + "，长度=" + len);
        System.out.println("服务器接收到的消息量=" + (++this.count));
        byte[] bytes = (UUID.randomUUID().toString().getBytes(CharsetUtil.UTF_8));
        ctx.channel().writeAndFlush(new MessageProtocol(bytes.length, bytes));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }


}
