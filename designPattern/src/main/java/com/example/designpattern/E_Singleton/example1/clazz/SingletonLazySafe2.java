package com.example.designpattern.E_Singleton.example1.clazz;

public class SingletonLazySafe2 {
    static SingletonLazySafe2 singletonLazy=null;

    public static SingletonLazySafe2 getSingletonLazy() {
        synchronized (SingletonLazySafe2.class){
            if(singletonLazy==null){
                singletonLazy=new SingletonLazySafe2();
            }
        }
        return singletonLazy;
    }
}
