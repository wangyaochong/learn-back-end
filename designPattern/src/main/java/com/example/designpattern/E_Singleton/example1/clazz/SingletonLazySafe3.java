package com.example.designpattern.E_Singleton.example1.clazz;

public class SingletonLazySafe3 {
    static SingletonLazySafe3 singletonLazy=null;

    public static SingletonLazySafe3 getSingletonLazy() {

        if(singletonLazy==null){
            synchronized (SingletonLazySafe3.class){
                if(singletonLazy==null){
                    singletonLazy=new SingletonLazySafe3();
                    System.out.println("初始化成功");
                }
            }
        }

        return singletonLazy;
    }
}
