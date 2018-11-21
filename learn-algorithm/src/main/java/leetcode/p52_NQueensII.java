package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class p52_NQueensII {
    public int totalNQueens(int n) {
        List<Integer> rowLeft = new LinkedList<>();
        List<Integer> colLeft = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            rowLeft.add(i);
            colLeft.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        getResult(rowLeft, colLeft, new boolean[2 * n + 1], new boolean[2 * n + 1], 0, stringBuilder, n);
        return stringBuilder.length();
    }

    public void getResult(List<Integer> rowLeft, List<Integer> colLeft, boolean[] slashMinus, boolean[] slashPlus, int lastJ, StringBuilder builder, int n) {
        if (colLeft.size() == 0 && rowLeft.size() == 0) {
            builder.append('1');
            return;
        }
        for (int i = 0; i < rowLeft.size(); i++) {
            Integer removeI = rowLeft.remove(i);
            for (int j = lastJ; j < colLeft.size(); j++) {
                Integer removeJ = colLeft.remove(j);
                if (slashPlus[removeI + removeJ]) {
                    colLeft.add(j, removeJ);
                    break;
                }
                slashPlus[removeI + removeJ] = true;
                if (slashMinus[removeI - removeJ + n]) {
                    slashPlus[removeI + removeJ] = false;
                    colLeft.add(j, removeJ);
                    break;
                }
                slashMinus[removeI - removeJ + n] = true;
                getResult(rowLeft, colLeft, slashMinus, slashPlus, j, builder, n);
                colLeft.add(j, removeJ);
                slashPlus[removeI + removeJ] = false;
                slashMinus[removeI - removeJ + n] = false;
            }
            rowLeft.add(i, removeI);
        }
    }


    @Test
    public void test() {
        System.out.println(totalNQueens(4));
    }

}
