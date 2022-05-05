package com.wangyaochong.kotlin.classHiarchey;

public class TestMain {
    public static void main(String[] args) {
        int ordinal = Sex.Man.ordinal();
        int ordinal2 = Sex.Woman.ordinal();
        System.out.println(ordinal);
        System.out.println(ordinal2);
    }
}
