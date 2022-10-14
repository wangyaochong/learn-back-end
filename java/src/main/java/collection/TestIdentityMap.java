package collection;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Set;

public class TestIdentityMap {
    public static void main(String[] args) {
        IdentityHashMap<String, String> map = new IdentityHashMap<>();
        map.put(new String("1"), "abc");
        map.put(new  String("1"), "bcd");
        String s = map.get("1");
        System.out.println(s);
        System.out.println(map);
        Set<String> strings = map.keySet();
        System.out.println(strings);
        Set<String> set = new HashSet<>(strings);
        System.out.println(set);
    }

}
