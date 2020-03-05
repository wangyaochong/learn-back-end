package netty.tcpprotocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;

public class MyClient {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        //创建客户端的对象
        //注意客户端使用的不是ServerBootstrap，而是Bootstrap

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).handler(new MyClientInitializer());
        System.out.println("客户端 ok 。。。");
        ChannelFuture connectChannelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
        ChannelFuture closeChannelFuture = connectChannelFuture.channel().closeFuture().sync();
        Future<?> future = group.shutdownGracefully();
    }
}

