package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p119 {
    public List<Integer> getRow(int numRows) {
        List<Integer> oneRow = new ArrayList<>();
        for (int x = 1; x <= numRows; x++) {
            oneRow.add(1);
            for (int i = 1; i < x; i++) {
                oneRow.set(i, oneRow.get(i - 1) + oneRow.get(i));
            }
        }
        return oneRow;
    }

    @Test
    public void test() {
        System.out.println(getRow(2));
    }
}
