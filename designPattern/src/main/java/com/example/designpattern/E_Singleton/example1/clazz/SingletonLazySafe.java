package com.example.designpattern.E_Singleton.example1.clazz;

public class SingletonLazySafe {
    static SingletonLazySafe singletonLazy=null;

    public synchronized static SingletonLazySafe getSingletonLazy() {
        if(singletonLazy==null){
            singletonLazy=new SingletonLazySafe();
        }
        return singletonLazy;
    }

    public static void main(String[] args) {
        Class<SingletonLazySafe3> singletonLazySafe3Class = SingletonLazySafe3.class;
        Class<SingletonLazySafe3> singletonLazySafe3Class2 = SingletonLazySafe3.class;
        System.out.println(singletonLazySafe3Class==singletonLazySafe3Class2);
    }
}
