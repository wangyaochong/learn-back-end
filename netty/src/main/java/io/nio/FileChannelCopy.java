package io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("netty/FileChannelWrite.txt");
        FileOutputStream outputStream = new FileOutputStream("netty/FileChannelCopy.txt");
        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = 1;
        while (read != -1) {
            byteBuffer.clear();//这个非常重要，否则read会一直是0
            read = inputChannel.read(byteBuffer);
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
            System.out.println("写完一行");
        }
        inputChannel.close();
        outputChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
