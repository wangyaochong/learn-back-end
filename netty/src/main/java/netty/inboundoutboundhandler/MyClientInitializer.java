package netty.inboundoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("encode", new MyLongToByteEncoder());
//        pipeline.addLast("decode", new MyByteToLongDecoder());
        pipeline.addLast("decode", new MyByteToLongDecoder2());
//        pipeline.addLast("encode2", new StringEncoder());
        pipeline.addLast("handler", new MyClientHandler());
    }
}
