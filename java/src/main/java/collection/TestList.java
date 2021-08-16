package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    @Test
    public void testRemove(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        for (String s : list) {
            if (s.equals("1")) {
                list.remove(s);
            }
        }
    }

    @Test
    public void testMaxLong(){
        System.out.println(Long.MAX_VALUE);
    }
}
