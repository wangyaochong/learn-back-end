package leetcode.byNumber;

import org.junit.Test;

public class p204_CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        int[] notPrime = new int[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == 0) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    notPrime[j * i] = 1;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(countPrimes(10));
    }
}
