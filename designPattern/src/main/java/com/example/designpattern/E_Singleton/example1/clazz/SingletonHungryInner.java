package com.example.designpattern.E_Singleton.example1.clazz;

public class SingletonHungryInner {
    private static final class Holder{
        public static SingletonHungryInner getSingleton() {
            return Holder.singleton;
        }
        private static SingletonHungryInner singleton = new SingletonHungryInner();
        static {
            System.out.println("静态代码段执行！");
        }
        public Holder(){
            System.out.println("holder初始化了");
        }
    }






    private SingletonHungryInner(){
        System.out.println("单例对象初始化了");
    }

    public void someMethod(){
        System.out.println("调用单例方法了！");
    }

    public static void someStaticMethod(){
        System.out.println("调用静态方法了！");
    }

    public static void main(String[] args) {
//        SingletonHungryInner singletonLazy = SingletonHungryInner.getSingleton();
//        singletonLazy.someMethod();
        System.out.println("test");

    }
}
