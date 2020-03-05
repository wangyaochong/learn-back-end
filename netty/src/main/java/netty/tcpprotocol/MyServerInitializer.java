package netty.tcpprotocol;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ch.pipeline().addLast(new MyMessageDecoder());
        ch.pipeline().addLast(new MyMessageEncoder());
        ch.pipeline().addLast(new MyServerHandler());
    }
}
