package leetcode.byNumber;

import org.junit.Test;

import java.util.*;

public class p187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Map<String, Boolean> cache = new HashMap<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (cache.containsKey(substring)) {
                result.add(substring);
            }
            cache.put(substring, true);
        }
        return new ArrayList<>(result);
    }

    @Test
    public void test() {

    }
}
