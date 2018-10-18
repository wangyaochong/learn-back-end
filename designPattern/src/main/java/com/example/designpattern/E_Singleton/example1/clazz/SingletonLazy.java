package com.example.designpattern.E_Singleton.example1.clazz;

public class SingletonLazy {
    static SingletonLazy singletonLazy=null;

    public static SingletonLazy getSingletonLazy() {
        if(singletonLazy==null){
            singletonLazy=new SingletonLazy();
        }
        return singletonLazy;
    }
}
