package netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class MyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.println("ctx对应的channel=" + ctx.channel() + "pipeline=" +
                ctx.pipeline() + "通过pipeline获取channel" + ctx.pipeline().channel());
        System.out.println("ctx对应的的handler=" + ctx.handler());
        if (msg instanceof HttpRequest) {
            System.out.println("ctx类型=" + ctx);
            System.out.println("pipeline hashcode" + ctx.pipeline().hashCode() + "，MyHttpServerHandler hashcode=" + this.hashCode());
            System.out.println("msg 类型=" + msg.getClass());
            System.out.println("客户端地址=" + ctx.channel().remoteAddress());
            HttpRequest request = (HttpRequest) msg;
            String uri = request.uri();
            if ("/favicon.ico".equals(uri)) {
                System.out.println("你请求了/favicon.ico");
                return;
            }
            ByteBuf content = Unpooled.copiedBuffer("hello,我是服务器", CharsetUtil.UTF_8);
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(response);
        }
    }
}
