package netty.protobuf_1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

public class NettyServer {
    public static void main(String[] args) throws Exception {

        /**
         * 1. 创建两个线程组bossGroup和workerGroup
         * 2. bossGroup只处理连接请求，真正的客户端业务处理，会交给workerGroup完成
         * 3. 两个都是无限循环
         * 4. bossGroup和workerGroup含有的子线程（NioEventLoop）的个数默认是cpu核数*2
         */

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);//如果不需要默认那么多线程数，可以设置参数
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup).
                channel(NioServerSocketChannel.class).
                option(ChannelOption.SO_BACKLOG, 128).
                childOption(ChannelOption.SO_KEEPALIVE, true).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                System.out.println("客户端 ch=" + ch);//可以使用集合管理channel，然后在channel间通信
                ch.pipeline().addLast("decoder", new ProtobufDecoder(netty.protobuf_1.StudentPOJO.Student.getDefaultInstance()));
                ch.pipeline().addLast(new netty.protobuf_1.NettyServerHandler());
            }
        });
        System.out.println("服务器准备好了。。。");
        ChannelFuture bootstrapChannelFuture = bootstrap.bind(6668).sync();
        bootstrapChannelFuture.addListener(future -> {
            System.out.println("端口绑定成功");
        });
        ChannelFuture closeChannelFuture = bootstrapChannelFuture.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();

    }
}
