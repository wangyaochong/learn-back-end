package netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //向管道加入处理器
        ch.pipeline().addLast("myHttpServerCodec", new HttpServerCodec());
        ch.pipeline().addLast("myTestHttpServerHandler", new TestHttpServerHandler());

    }
}
