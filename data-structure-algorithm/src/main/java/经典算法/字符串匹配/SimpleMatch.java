package 经典算法.字符串匹配;

import org.junit.Test;

public class SimpleMatch {


    public int search(String major, String p) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < major.length() && j < p.length()) {
            if (major.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;//如果不相等，i需要回溯
                j = 0;
            }
            count++;

        }
        System.out.println("计算次数=" + count);

        if (j == p.length()) {
            return i - j;
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(search("1234567812345678123456789", "123456789"));
        System.out.println(search("11234", "234"));
        System.out.println(search("1234", "235"));
    }
}
