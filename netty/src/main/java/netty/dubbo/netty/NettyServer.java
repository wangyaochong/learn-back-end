package netty.dubbo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import netty.tcpprotocol.MyMessageDecoder;
import netty.tcpprotocol.MyMessageEncoder;

public class NettyServer {


    public static void startServer0(String hostName, int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);//如果不需要默认那么多线程数，可以设置参数
        EventLoopGroup workerGroup = new NioEventLoopGroup(16);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new MyMessageEncoder());
                        ch.pipeline().addLast(new MyMessageDecoder());
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });
        ChannelFuture bootstrapChannelFuture = bootstrap.bind(6668).sync();
        ChannelFuture closeChannelFuture = bootstrapChannelFuture.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
