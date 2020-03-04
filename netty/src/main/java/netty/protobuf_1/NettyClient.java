package netty.protobuf_1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.util.concurrent.Future;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        //创建客户端的对象
        //注意客户端使用的不是ServerBootstrap，而是Bootstrap

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast("encoder", new ProtobufEncoder());
                ch.pipeline().addLast(new NettyClientHandler());
            }
        });
        System.out.println("客户端 ok 。。。");
        ChannelFuture connectChannelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
        ChannelFuture closeChannelFuture = connectChannelFuture.channel().closeFuture().sync();
        Future<?> future = eventExecutors.shutdownGracefully();

    }
}
