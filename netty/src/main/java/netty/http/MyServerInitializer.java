package netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //向管道加入处理器
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("myHttpServerCodec", new HttpServerCodec());
        pipeline.addLast("myTestHttpServerHandler", new MyHttpServerHandler());
        System.out.println("ok");
    }
}
