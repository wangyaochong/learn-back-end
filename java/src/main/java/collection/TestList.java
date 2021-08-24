package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    @Test
    public void testRemove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        for (String s : list) {
            if (s.equals("2")) {
                list.remove(s);
            }
        }
    }

    @Test
    public void testRemove2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("1");
        int size = list.size();
        for(int i = 0; i< size; i++){
            String s = list.get(i);
            if(s.equals("1")){
                list.remove(s);
            }
        }
        System.out.println(list);
    }

    @Test
    public void testRemove3() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("1");
        System.out.println(list);
        for(int i = 0; i< list.size(); i++){
            String s = list.get(i);
            if(s.equals("1")){
                list.remove(s);
            }
        }
        System.out.println(list);
    }

    @Test
    public void testMaxLong() {
        System.out.println(Long.MAX_VALUE);
    }
}
