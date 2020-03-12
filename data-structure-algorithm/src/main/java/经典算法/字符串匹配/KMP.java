package 经典算法.字符串匹配;

import org.junit.Test;

import java.util.Arrays;
public class KMP {
    public int[] next(String p) {
        int length = p.length();
        int[] next = new int[length];
        next[0] = -1;
        int pre = -1;//前缀下标
        int post = 0;//后缀下标
        while (post < length - 1) {
            if (pre == -1 || p.charAt(pre) == p.charAt(post)) {
                pre++;
                post++;
                if (p.charAt(pre) != p.charAt(post)) {//如果说前缀和后缀的最后一个字符串相同
                    next[post] = pre;
                } else {
                    //就比如121212，当在最后一个2不匹配时，前面的其实有121前缀和121后缀，移动3位后，121前缀后面还是2，肯定不匹配，所以可以直接在往前跳一次
                    next[post] = next[pre];
                }
                next[post] = pre;
            } else {
                pre = next[pre];
            }
        }
        return next;
    }

    public int kmpSearch(String major, String p) {
        int[] next = next(p);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < major.length() && j < p.length()) {
            if (j == -1 || major.charAt(i) == p.charAt(j)) {//如果说当前字符串相同或者p串没有匹配的了，则需要将主串和模式串下标都后移
                i++;
                j++;
            } else {
                j = next[j];
            }
            count++;
        }
        System.out.println("计算次数=" + count);
        if (j == p.length()) {//如果成功匹配，返回下标
            return i - j;
        }
        return -1;
    }

    @Test
    public void testSearch() {
        System.out.println(kmpSearch("1234567812345678123456789", "123456789"));
        System.out.println(kmpSearch("111111111234", "23"));
        System.out.println(kmpSearch("1234", "235"));
    }

    @Test
    public void testNext() {
//        System.out.println(Arrays.toString(next("123123123")));
        System.out.println(Arrays.toString(next("121212")));

//        System.out.println(Arrays.toString(next("123123")));
//        System.out.println(Arrays.toString(next("1231234")));
//        System.out.println(Arrays.toString(next("1231234123")));
    }
}
