package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p119_PascalsTriangleII {
    public List<Integer> getRow(int numRows) {
        List<Integer> oneRow = new ArrayList<>();
        for (int x = 0; x <= numRows; x++) {
            oneRow.add(1);
            for (int i = x - 1; i >= 1; i--) {
                oneRow.set(i, oneRow.get(i - 1) + oneRow.get(i));
            }
        }
        return oneRow;
    }

    @Test
    public void test() {
        System.out.println(getRow(5));
    }
}
