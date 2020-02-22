package leetcode.byNumber;

import org.junit.Test;

import java.util.*;

public class p49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if (!resultMap.containsKey(tmp)) {
                resultMap.put(tmp, new ArrayList<>());
            }
            resultMap.get(tmp).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }


    @Test
    public void test() {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
