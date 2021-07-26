package netty.dubbo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import netty.tcpprotocol.MyMessageDecoder;
import netty.tcpprotocol.MyMessageEncoder;

import java.lang.reflect.Proxy;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyClient {
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static NettyClientHandler clientHandler = null;

    public Object getBean(final Class<?> serverClass, final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{serverClass}, (proxy, method, args)
                -> clientHandler.getResult(providerName + args[0], UUID.randomUUID().toString()));
    }

    public NettyClient() {
        try {
            initClient();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized static void initClient() throws InterruptedException {
        clientHandler = new NettyClientHandler();
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup(16);
        //创建客户端的对象
        //注意客户端使用的不是ServerBootstrap，而是Bootstrap

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new MyMessageEncoder());
                        ch.pipeline().addLast(new MyMessageDecoder());
                        ch.pipeline().addLast(clientHandler);
                    }
                });
        System.out.println("客户端 ok 。。。");
        ChannelFuture connectChannelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
//        ChannelFuture closeChannelFuture = connectChannelFuture.channel().closeFuture().sync();
//        Future<?> future = eventExecutors.shutdownGracefully();

    }
}
