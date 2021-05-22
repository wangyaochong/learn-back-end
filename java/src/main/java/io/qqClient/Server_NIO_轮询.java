package io.qqClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Server_NIO_轮询 {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<SocketChannel> list = new ArrayList<>();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            SocketChannel channel = serverSocketChannel.accept();
            if (channel != null) {
                channel.configureBlocking(false);
                list.add(channel);
            }
            for (SocketChannel client : list) {//即使客户端没有发送数据也要轮询，会导致cpu空转浪费
                int size = client.read(byteBuffer);
                if (size > 0) {
                    byteBuffer.flip();
                    System.out.println(Charset.forName("utf-8").decode(byteBuffer));
                    byteBuffer.clear();//使用完后需要清除
                }
            }
            Thread.sleep(1000);
        }
    }
}
