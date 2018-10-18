package com.example.designpattern.E_Singleton.example1;

import com.example.designpattern.E_Singleton.example1.clazz.SingletonHungry;

public class Main {
    public static void main(String[] args) {
        System.out.println("start.");
        SingletonHungry s1= SingletonHungry.getInstance();
        SingletonHungry s2= SingletonHungry.getInstance();
        System.out.println(s1==s2);
        System.out.println("end.");
    }
}
