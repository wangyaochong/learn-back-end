package leetcode;

import org.junit.Test;

public class p868_BinaryGap {
    public int binaryGap(int N) {
        StringBuilder stringBuilder = new StringBuilder();
        int tmp;
        while (N != 0) {
            tmp = N % 2;
            N = N / 2;
            stringBuilder.append(tmp);
        }
        int[] lastOneLoc = new int[stringBuilder.length()];
        if (stringBuilder.charAt(0) == '1') {
            lastOneLoc[0] = 0;
        } else {
            lastOneLoc[0] = Integer.MAX_VALUE;
        }
        int max = 0;
        for (int i = 1; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '1') {
                lastOneLoc[i] = i;
                if (i >= 1 && max < lastOneLoc[i] - lastOneLoc[i - 1]) {
                    max = lastOneLoc[i] - lastOneLoc[i - 1];
                }
            } else {
                lastOneLoc[i] = lastOneLoc[i - 1];
            }
        }
        return max;
    }


    @Test
    public void test() {
        System.out.println(binaryGap(22));
    }
}
