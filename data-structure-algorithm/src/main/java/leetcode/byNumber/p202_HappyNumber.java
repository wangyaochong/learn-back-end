package leetcode.byNumber;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p202_HappyNumber {

    public boolean isHappy(int n) {
        Map<Integer, Boolean> cache = new HashMap<>();
        while (cache.get(n) == null) {
            cache.put(n, true);
            int sum = 0;
            int mod;
            while (n != 0) {
                mod = n % 10;
                sum += mod * mod;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(isHappy(2));
    }
}
