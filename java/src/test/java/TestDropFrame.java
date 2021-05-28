import org.junit.Test;

public class TestDropFrame {

    @Test
    public void test(){
        System.out.println("开始运行代码");
        int inside = inside(1, 2);
        System.out.println(inside);
        System.out.println(inside);
        System.out.println(inside);
        System.out.println(inside);
        int a = 0;
        return;
    }

    public int inside(int addCount,int mulCount) {
        int a=0;
        System.out.println("开始计算");
        a=a+addCount;
        a = a * mulCount;
        System.out.println("结束计算");
        a = addCount*mulCount;
        return a;
    }
}
