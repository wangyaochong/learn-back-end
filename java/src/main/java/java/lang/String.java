package java.lang;

import org.junit.Test;


/**
 * @author wangyaochong
 * @date 2020/3/15 11:33
 */
public class String {

//    由于双亲委派机制，程序员自己写的String类无法被加载，
//    因为String.class已经被根加载器加载过了

    public static void main(String[] args) {
        System.out.println("String class");
    }

    public char charAt(String str, int loc) {
        return 'c';
    }

    @Test
    public void test() {
        System.out.println(charAt("", 0));
    }
}
