package netty.dubbo.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;
import netty.tcpprotocol.MessageProtocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NettyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private ChannelHandlerContext context = null;
    private ConcurrentHashMap<String, String> threadLockAndResultMap = new ConcurrentHashMap<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    //    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        String value = msg.toString();
//        String[] split = value.split("---");
//
//        String anObject = split[split.length - 1];
//        for (Map.Entry<String, String> stringStringEntry : threadLockAndResultMap.entrySet()) {
//            String key = stringStringEntry.getKey();
//            if (key.equals(anObject)) {
//                synchronized (key) {
//                    stringStringEntry.setValue(value);
//                    key.notify();
//                    break;
//                }
//            }
//        }
//    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol message) throws Exception {
        String value = new String(message.getContent(), CharsetUtil.UTF_8);
        String[] split = value.split("---");
        String anObject = split[split.length - 1];
        for (Map.Entry<String, String> stringStringEntry : threadLockAndResultMap.entrySet()) {
            String key = stringStringEntry.getKey();
            if (key.equals(anObject)) {
                synchronized (key) {
                    stringStringEntry.setValue(value);
                    key.notify();
                    break;
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    //如果不使用字符串作为lock，需要使用两个map，一个是requestId对应的lock，另一个是requestId对应的value
    //在多线程情况下，必须要进行设置requestId，否则可能请求和相应不是一一对应，如果错位唤醒，那么数据就都乱了
    public String getResult(String para, String requestId) {
        String msg = para + "---" + requestId;
        byte[] bytes = msg.getBytes(CharsetUtil.UTF_8);
        Channel channel = context.channel();
        //测试设置AttributeKey
        AttributeKey<String> requestId1 = AttributeKey.valueOf("requestId");
        channel.attr(requestId1).set(requestId);
        channel.writeAndFlush(new MessageProtocol(bytes.length, bytes));
//        context.writeAndFlush(new MessageProtocol(bytes.length, bytes));
        synchronized (requestId) {
            try {
                threadLockAndResultMap.put(requestId, "");
                requestId.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String attrRequestId = channel.attr(requestId1).get();
        System.out.println("attrRequestId="+attrRequestId);
       // channel.attr(requestId1).remove();
        return threadLockAndResultMap.remove(requestId);
    }
}
