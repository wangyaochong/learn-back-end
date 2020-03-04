package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * scattering：将数据写入buffer时，可以采用buffer数组，依次写入
 * <p>
 * gathering：
 */
public class ScatteringAndGathering {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        serverSocketChannel.socket().bind(inetSocketAddress);
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long read = socketChannel.read(byteBuffers);
                byteRead += read;
                System.out.println("byteRead=" + byteRead);
                Arrays.stream(byteBuffers).map(e -> "position=" + e.position() + ",limit=" + e.limit()).forEach(System.out::println);
                Arrays.stream(byteBuffers).forEach(ByteBuffer::flip);
            }
            long byteWrite = 0;
            while (byteWrite < messageLength) {
                long write = socketChannel.write(byteBuffers);
                byteWrite += write;
                Arrays.stream(byteBuffers).forEach(ByteBuffer::clear);
                System.out.println("byteRead:=" + byteRead + ",byteWrite:=" + byteWrite + ",messageLength" + messageLength);
            }
        }
    }
}
