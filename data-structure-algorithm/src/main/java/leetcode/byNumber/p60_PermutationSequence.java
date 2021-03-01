package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p60_PermutationSequence {
    public String getPermutation(int n, int k) {

        List<String> cache = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cache.add(Integer.toString(i + 1));
        }
        k = k - 1;//下标从0开始
        StringBuilder result = new StringBuilder();
        while (cache.size() > 0) {
            int count=factorial(cache.size() - 1);
            int index = k / count;
            k = k - count * index;
            result.append(cache.remove(index));
        }
        return result.toString();

    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    @Test
    public void testFac() {
        System.out.println(factorial(5));
        System.out.println(getPermutation(4, 9));
    }

}
