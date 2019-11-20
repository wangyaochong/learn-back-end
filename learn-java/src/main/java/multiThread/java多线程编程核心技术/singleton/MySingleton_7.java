package multiThread.java多线程编程核心技术.singleton;

public enum MySingleton_7 {
    INSTANCE;

    public void doSomething() {
        System.out.println("do something");
    }

    public MySingleton_7 getInstance() {
        return INSTANCE;
    }

}

