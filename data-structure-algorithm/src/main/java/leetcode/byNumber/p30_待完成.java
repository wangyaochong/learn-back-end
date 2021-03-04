package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class p30_待完成 {
    public List<Integer> findSubstring(String s, String[] words) {
        return null;
    }

    @Test
    public void test() {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word", "good", "best","good"}));
    }
}
