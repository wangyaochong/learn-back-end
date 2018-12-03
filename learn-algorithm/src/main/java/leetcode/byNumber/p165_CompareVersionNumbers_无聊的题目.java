package leetcode.byNumber;

import org.junit.Test;

public class p165_CompareVersionNumbers_无聊的题目 {


    @Test
    public void test() {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
    }


    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}
