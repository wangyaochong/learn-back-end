package netty.inboundoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast("decoder", new MyByteToLongDecoder());
        pipeline.addLast("decoder", new MyByteToLongDecoder2());
        pipeline.addLast("encode", new MyLongToByteEncoder());
//        pipeline.addLast("decoder2", new StringDecoder());
        pipeline.addLast("handler", new MyServerHandler());
    }


}
