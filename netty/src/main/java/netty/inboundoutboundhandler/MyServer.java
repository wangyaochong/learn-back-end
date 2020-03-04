package netty.inboundoutboundhandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);//如果不需要默认那么多线程数，可以设置参数
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup).
                channel(NioServerSocketChannel.class).
                option(ChannelOption.SO_BACKLOG, 128).
                childOption(ChannelOption.SO_KEEPALIVE, true).childHandler(new MyServerInitializer());
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
