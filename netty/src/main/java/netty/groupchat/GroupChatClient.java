package netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GroupChatClient {
    String host;
    int port;

    public GroupChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap().group(eventLoopGroup).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast(new GroupChatClientHandler());
            }
        });
        //注意，sync会跑出异常，而await需要在channel.cause()方法中提取异常。
        ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
        boolean await = channelFuture.await(5, TimeUnit.SECONDS);
        if (await) {
            System.out.println("是否连接成功？="+ await);
        }
        Channel channel = channelFuture.channel();
        System.out.println("-----------" + channel.localAddress() + "-------------");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            channel.writeAndFlush(msg);
        }
        eventLoopGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws InterruptedException {
        new GroupChatClient("127.0.0.1", 7001).run();
    }

}
