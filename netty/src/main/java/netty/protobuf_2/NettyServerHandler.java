package netty.protobuf_2;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

//public class NettyServerHandler extends ChannelInboundHandlerAdapter {
public class NettyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object message) throws Exception {
        super.channelRead(ctx, message);
        MyDataInfo.MyMessage o = (MyDataInfo.MyMessage) message;
        System.out.println("NettyServerHandler");
        if (o.getDataType().equals(MyDataInfo.MyMessage.DataType.StudentType)) {
            MyDataInfo.Student one = o.getStudent();
            System.out.println("学生id=" + one.getId() + ", name= " + one.getName());
        } else {
            MyDataInfo.Worker one = o.getWorker();
            System.out.println("学生id=" + one.getAge() + ", name= " + one.getName());
        }
//        System.out.println("客户端发送的数据 id=" + student.getId() + ",name=" + student.getName());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

        if (msg.getDataType().equals(MyDataInfo.MyMessage.DataType.StudentType)) {
            MyDataInfo.Student one = msg.getStudent();
            System.out.println("学生id=" + one.getId() + ", name= " + one.getName());
        } else {
            MyDataInfo.Worker one = msg.getWorker();
            System.out.println("学生id=" + one.getAge() + ", name= " + one.getName());
        }
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
