package io.两种从控制台读取字符串的方法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 方式二BufferedReader {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        System.out.println(s);
    }
}
