package netty.protobuf_1;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

//public class NettyServerHandler extends ChannelInboundHandlerAdapter {
public class NettyServerHandler extends SimpleChannelInboundHandler<netty.protobuf_1.StudentPOJO.Student> {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        netty.protobuf_1.StudentPOJO.Student student = (netty.protobuf_1.StudentPOJO.Student) msg;
        System.out.println("客户端发送的数据 id=" + student.getId() + ",name=" + student.getName());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, netty.protobuf_1.StudentPOJO.Student msg) throws Exception {
        System.out.println("客户端发送的数据 id=" + msg.getId() + ",name=" + msg.getName());
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
