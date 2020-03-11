package multiThread.java多线程编程核心技术.pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class CharStream {
    public static void main(String[] args) throws IOException, InterruptedException {
//        PipedOutputStream out = new PipedOutputStream();
//        PipedInputStream in = new PipedInputStream();
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        writer.connect(reader);
//        out.connect(in);
        new Thread(() -> {
            System.out.println("read:");
            char[] bytesArray = new char[20];
            try {
                int readLength = reader.read(bytesArray);
                while (readLength != -1) {
                    String newData = new String(bytesArray, 0, readLength);
                    System.out.print(newData);
                    readLength = reader.read(bytesArray);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(2000);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                String outData = "" + (i + 1);
                try {
                    writer.write(outData.toCharArray());
                    System.out.println(outData);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
