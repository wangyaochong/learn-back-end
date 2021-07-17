package com.example.shiro.util;

import java.util.Random;

public class UtilSalt {


    public static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&*()_+-=";
    /**
     * 生成salt
     *
     * @param n 长度
     * @return 生成的salt
     */
    public static String getSalt(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            Random random = new Random();
            int i = random.nextInt(chars.length());
            result.append(chars.charAt(i));
            n--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt(5));
    }
}
