package io.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestCopyFile{

    @Test
    public void testWithNIO() throws IOException {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        FileOutputStream fo=new FileOutputStream(new File("./testLargeCopy.txt"));
        //获得传输通道channel
        FileChannel inChannel=new RandomAccessFile("./testLarge.txt","rw").getChannel() ;
        FileChannel outChannel=fo.getChannel();
        //获得容器buffer

        MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024*2048 );
//        ByteBuffer buffer=ByteBuffer.allocate(1024*1024);
        while(true){
            //判断是否读完文件
            buffer.clear();
            int eof =inChannel.read(buffer);
            if(eof==-1){
                break;
            }
            //重设一下buffer的position=0，limit=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer，重设position=0,limit=capacity
        }
        inChannel.close();
        outChannel.close();
        fo.close();
        stopWatch.stop();
        log.info("时间{}",stopWatch.getLastTaskTimeMillis());
    }
    @Test
    public void testWithIO() throws IOException {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        FileInputStream fi=new FileInputStream(new File("./testLarge.txt"));
        FileOutputStream fo=new FileOutputStream(new File("./testLargeCopy.txt"));
        byte[] bytes=new byte[1024*2048];
        int read = fi.read(bytes);
        while(read!=-1){
            fi.read(bytes);
            fo.write(bytes);
            read=fi.read(bytes);
        }
        fi.close();
        fo.close();
        stopWatch.stop();
        log.info("时间{}",stopWatch.getLastTaskTimeMillis());
    }

    @Test
    public void testFastNIO(){

    }

}
