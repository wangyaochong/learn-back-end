package leetcode;

import org.junit.Test;

public class p96_UniqueBinarySearchTrees_画重点_卡特兰数 {


    public int numTrees(int n) {
        return getResult(1, n);
    }

    int[] cache = new int[1000];

    public int getResult(int start, int end) {
        if (start > end) {
            return 1;
        }
        if (cache[end - start] != 0) {
            return cache[end - start];
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += getResult(start, i - 1) * getResult(i + 1, end);
        }
        cache[end - start] = sum;
        return sum;
    }

    @Test
    public void test() {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
    }
}
