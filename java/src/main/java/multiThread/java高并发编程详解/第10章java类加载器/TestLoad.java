package multiThread.java高并发编程详解.第10章java类加载器;

/**
 * @author wangyaochong
 * @date 2020/3/15 17:38
 */
class Code {
    public Code() {
        System.out.println("code 构造方法");
    }

    {
        System.out.println("code 构造块");
    }

    static {
        System.out.println("code static");
    }

}

public class TestLoad {
    int i;

    static {
        System.out.println("TestLoad静态方法");
    }

    {
        System.out.println("TestLoad构造代码块3");
    }

    {
        System.out.println("TestLoad构造代码块");
    }

    public TestLoad() {
        System.out.println("构造方法");
    }

    {
        System.out.println("TestLoad构造代码块2");
    }

    public static void main(String[] args) {

        TestLoad testLoad = new TestLoad();
        TestLoad testLoad2 = new TestLoad();
        new Code();
        new Code();
    }

}
