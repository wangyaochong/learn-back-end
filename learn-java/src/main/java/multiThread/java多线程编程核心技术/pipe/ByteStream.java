package multiThread.java多线程编程核心技术.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ByteStream {
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream();
//        out.connect(in);//这两行代码都可以
        in.connect(out);
        new Thread(() -> {
            System.out.println("read:");
            byte[] bytesArray = new byte[20];
            try {
                int readLength = in.read(bytesArray);
                while (readLength != -1) {
                    String newData = new String(bytesArray, 0, readLength);
                    System.out.print("读入" + newData);
                    readLength = in.read(bytesArray);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(2000);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                String outData = "" + (i + 1);
                try {
                    out.write(outData.getBytes());
                    System.out.println("输出" + outData);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
