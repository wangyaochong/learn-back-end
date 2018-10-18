package com.example.designpattern.E_Singleton.example1.clazz;

public class SingletonHungry {
    private static SingletonHungry singleton=new SingletonHungry();
    private SingletonHungry(){
        System.out.println("生成了一个实例。");
    }
    public static SingletonHungry getInstance(){
        return singleton;
    }
}