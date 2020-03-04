package io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelCopyTrans {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("netty/FileChannelWrite.txt");
        FileOutputStream outputStream = new FileOutputStream("netty/FileChannelCopy.txt");
        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        inputChannel.close();
        outputChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
