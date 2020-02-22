package io.nio;

import io.bio.TestIO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestNIO {
    @Test
    public void test() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(TestIO.fileName, "rw");
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
        File file = new File(TestIO.fileNameLarge);
        if (!file.exists()) {
            file.createNewFile();
        }
        log.info("开始写入文件！");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        FileOutputStream fileOutputStream = new FileOutputStream(TestIO.fileNameLarge);
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
        File file = new File(TestIO.fileNameLarge);
        if (!file.exists()) {
            file.createNewFile();
        }
        log.info("开始写入文件！");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        FileOutputStream fileOutputStream = new FileOutputStream(TestIO.fileNameLarge);
        fileOutputStream.write(longText.getBytes());
        fileOutputStream.close();
        stopWatch.stop();
        log.info("时间{}", stopWatch.getLastTaskTimeMillis());
        log.info("文件写入以返回！");
    }

    @Test
    public void testWrite10000RowBIO() throws IOException {
        String longText = "21341234123\n";
        File file = new File(TestIO.fileNameLarge);
        if (!file.exists()) {
            file.createNewFile();
        }
        log.info("开始写入文件！");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        FileOutputStream fileOutputStream = new FileOutputStream(TestIO.fileNameLarge);
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
        File file = new File(TestIO.fileNameLarge);
        if (!file.exists()) {
            file.createNewFile();
        }
        log.info("开始写入文件！");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        FileOutputStream fileOutputStream = new FileOutputStream(TestIO.fileNameLarge);
        for (int i = 0; i < 500000; i++) {
            fileOutputStream.write(longText.getBytes());
        }
        fileOutputStream.close();
        stopWatch.stop();
        log.info("时间{}", stopWatch.getLastTaskTimeMillis());
        log.info("文件写入以返回！");
    }

}
