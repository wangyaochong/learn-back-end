package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p89_GrayCode_讨论中有一种位运算是真的牛 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(Collections.singletonList(0));
        getResult(0, n, result);
        return result;
    }

    public void getResult(int current, int target, List<Integer> result) {
        if (current >= target) {
            return;
        }
        List<Integer> cp = new ArrayList<>(result);
        for (int i = cp.size() - 1; i >= 0; i--) {
            result.add((pow2(current) + cp.get(i)));
        }
        getResult(current + 1, target, result);
    }

    public int pow2(int n) {
        int result = 1;
        int i = 0;
        while (i < n) {
            result *= 2;
            i += 1;
        }
        return result;
    }


    @Test
    public void test() {
        System.out.println(grayCode(3));
    }
}
