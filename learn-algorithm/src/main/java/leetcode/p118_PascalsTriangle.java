package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> lastRow = null;
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 1; x <= numRows; x++) {
            List<Integer> oneRow = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                if (i == 0 || i == x - 1) {
                    oneRow.add(1);
                } else {
                    oneRow.add(lastRow.get(i - 1) + lastRow.get(i));
                }
            }
            result.add(oneRow);
            lastRow = oneRow;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(generate(9));
    }
}
