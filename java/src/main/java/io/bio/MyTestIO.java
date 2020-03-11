package io.bio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.UtilLog;

import java.io.*;

@Slf4j
public class MyTestIO {
    public static String fileName = "./test.txt";
    public static String fileNameLarge = "./testLarge.txt";
    public static String fileNameLarge10000 = "./testLarge.txt";

    @Test
    public void testStream() throws IOException {

        File test = new File(fileName);
        if (!test.exists()) {
            test.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(test);
        fileOutputStream.write("你好".getBytes());
        fileOutputStream.close();

        FileInputStream inputStream = new FileInputStream(test);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        log.info(UtilLog.prefixLog(new String(bytes)));

    }

    @Test
    public void testWriterReader() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("测试");
        fileWriter.close();

        FileReader fileReader = new FileReader(fileName);
        char[] chars = new char[1000];
        fileReader.read(chars);
        fileReader.close();
        System.out.println(chars[0]);
        System.out.println(chars);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String s = bufferedReader.readLine();
            bufferedReader.close();
            System.out.println(s);
        }
    }

    @Test
    public void testString() {
    }

}
