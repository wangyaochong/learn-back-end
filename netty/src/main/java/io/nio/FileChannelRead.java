package io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelRead {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("netty/FileChannelWrite.txt");
        FileChannel fileChannel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);
        byte[] array = byteBuffer.array();
        System.out.println(new String(array));
        fileChannel.close();
        inputStream.close();
    }
}
