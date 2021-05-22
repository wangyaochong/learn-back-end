package io.nio;

import cn.hutool.core.date.StopWatch;
import io.bio.MyTestIO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestNIO {
    @Test
    public void test() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(MyTestIO.fileName, "rw");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = channel.read(byteBuffer);
        while (read != -1) {

        }
    }

    @Test
    public void testWriteNIO() throws IOException {
        String longText = "21341234123";
        for (int i = 0; i < 20; i++) {
            longText += longText;
        }
        log.info(String.format("长度为%d", longText.length()));
        File file = new File(MyTestIO.fileNameLarge);
        if (!file.exists()) {
            file.createNewFile();
        }
        log.info("开始写入文件！");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        FileOutputStream fileOutputStream = new FileOutputStream(MyTestIO.fileNameLarge);
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(longText.getBytes().length);
        channel.write(byteBuffer);
        channel.close();
        fileOutputStream.close();
        stopWatch.stop();
        log.info("时间{}", stopWatch.getLastTaskTimeMillis());
        log.info("文件写入以返回！");

    }

    @Test
    public void testWriteBIO() throws IOException {
        String longText = "21341234123";
        for (int i = 0; i < 20; i++) {
            longText += longText;
        }
        log.info(String.format("长度为%d", longText.length()));
        File file = new File(MyTestIO.fileNameLarge);
        if (!file.exists()) {
            file.createNewFile();
        }
        log.info("开始写入文件！");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        FileOutputStream fileOutputStream = new FileOutputStream(MyTestIO.fileNameLarge);
        fileOutputStream.write(longText.getBytes());
        fileOutputStream.close();
        stopWatch.stop();
        log.info("时间{}", stopWatch.getLastTaskTimeMillis());
        log.info("文件写入以返回！");
    }

    @Test
    public void testWrite10000RowBIO() throws IOException {
        String longText = "21341234123\n";
        File file = new File(MyTestIO.fileNameLarge);
        if (!file.exists()) {
            file.createNewFile();
        }
        log.info("开始写入文件！");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        FileOutputStream fileOutputStream = new FileOutputStream(MyTestIO.fileNameLarge);
        for (int i = 0; i < 1000000; i++) {
            fileOutputStream.write(longText.getBytes());
        }
        fileOutputStream.close();
        stopWatch.stop();
        log.info("时间{}", stopWatch.getLastTaskTimeMillis());
        log.info("文件写入以返回！");
    }

    @Test
    public void testWrite10000RowNIO() throws IOException {
        String longText = "21341234123\n";
        File file = new File(MyTestIO.fileNameLarge);
        if (!file.exists()) {
            file.createNewFile();
        }
        log.info("开始写入文件！");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        FileOutputStream fileOutputStream = new FileOutputStream(MyTestIO.fileNameLarge);
        for (int i = 0; i < 1000000; i++) {
            fileOutputStream.write(longText.getBytes());
        }
        fileOutputStream.close();
        stopWatch.stop();
        log.info("时间{}", stopWatch.getLastTaskTimeMillis());
        log.info("文件写入以返回！");
    }

}
