package netty.inboundoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyByteToLongDecoder extends ByteToMessageDecoder {
    /**
     * decode 会被调用多次，直到没有新的元素被添加到list，或者是ByteBuf没有更多的可读字节为止
     *
     * @param ctx
     * @param in
     * @param out
     * @throws Exception
     */

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder decoder调用");
        int i = in.readableBytes();
        if (i >= 8) {
            out.add(in.readLong());
        }
    }
}
