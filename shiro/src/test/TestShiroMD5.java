package com.example.shiro.test;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestShiroMD5 {
    public static void main(String[] args) {
//        Md5Hash md5Hash = new Md5Hash();
//        md5Hash.setBytes("123".getBytes());
//        String s = md5Hash.toHex();
//        System.out.println(s);

        Md5Hash md5Hash = new Md5Hash("abc");
        System.out.println(md5Hash.toHex());

        Md5Hash md5Hash1=new Md5Hash("abc","xgde");
        System.out.println(md5Hash1.toHex());

        Md5Hash md5Hash2=new Md5Hash("abc","xgde",1024);
        System.out.println(md5Hash2.toHex());
    }
}
