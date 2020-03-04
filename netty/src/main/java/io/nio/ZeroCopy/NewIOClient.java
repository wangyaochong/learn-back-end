package io.nio.ZeroCopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 7001));
        String fileName = "D://test.log";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        long total = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        long startTime = System.currentTimeMillis();
        System.out.println("新版io发送总字节数：" + total + "，耗时：" + (System.currentTimeMillis() - startTime));
        socketChannel.close();
    }
}
