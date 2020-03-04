package io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWrite {
    public static void main(String[] args) throws IOException {
        String str = "hello wangyaochong";
        //创建一个输出流
        FileOutputStream outputStream = new FileOutputStream("netty/FileChannelWrite.txt");
        FileChannel fileChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将str放入到byteBuffer
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();

        fileChannel.write(byteBuffer);
        fileChannel.close();
        outputStream.close();

    }
}
