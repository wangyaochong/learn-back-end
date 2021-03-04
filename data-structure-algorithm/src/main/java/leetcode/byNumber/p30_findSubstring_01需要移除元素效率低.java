package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class p30_findSubstring_01需要移除元素效率低 {
    //会超时
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        int wordLength = words[0].length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<String> cache = new ArrayList<>(Arrays.asList(words));
            int removedCount = 0;
            while (true) {
                boolean hasSame = false;
                Iterator<String> iterator = cache.iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (s.indexOf(next, i + wordLength * removedCount) == i + wordLength * removedCount) {
                        iterator.remove();
                        removedCount++;
                        hasSame = true;
                        iterator = cache.iterator();
                    }
                }
                if (!hasSame) {
                    break;
                }
            }
            if (cache.size() == 0) {
                result.add(i);
            }

        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word", "good", "best","good"}));
    }
}
