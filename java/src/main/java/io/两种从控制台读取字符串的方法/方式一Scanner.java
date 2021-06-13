package io.两种从控制台读取字符串的方法;

import java.util.Scanner;

public class 方式一Scanner {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
    }
}
