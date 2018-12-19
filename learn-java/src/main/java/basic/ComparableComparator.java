package basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Comparator;

public class ComparableComparator {
    class LongComparator implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {
            if (o1 < o2) {
                return -1;
            }
            if (o1 > o2) {
                return 1;
            }
            return 0;
        }
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class MyClass implements Comparable<MyClass> {
        String name;

        @Override
        public int compareTo(MyClass o) {
            return name.compareTo(o.getName());
        }
    }


    @Test
    public void testComparator() {
        LongComparator a = new LongComparator();
        System.out.println(a.compare(1L, 2L));
    }


    @Test
    public void testComparable() {
        MyClass myClass1 = new MyClass("class1");
        MyClass myClass2 = new MyClass("class2");
        System.out.println(myClass1.compareTo(myClass2));
    }

}
