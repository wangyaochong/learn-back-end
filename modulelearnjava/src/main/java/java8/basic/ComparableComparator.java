package java8.basic;

import org.junit.Test;

import java.util.Comparator;

public class ComparableComparator {
    class A implements Comparator<Long>{
        @Override
        public int compare(Long o1, Long o2) {
            return 0;
        }
    }
    @Test
    public void test(){
        A a=new A();
//        a.compare()
//        Comparator
    }
}
