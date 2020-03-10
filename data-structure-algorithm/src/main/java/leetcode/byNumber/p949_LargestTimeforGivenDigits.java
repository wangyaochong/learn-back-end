package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class p949_LargestTimeforGivenDigits {

    private String finalResult = "";

    public String largestTimeFromDigits(int[] A) {
        List<Integer> candidate = Arrays.stream(A).boxed().collect(Collectors.toCollection(LinkedList::new));
        getResult(candidate, "", 0);
        return finalResult;
    }

    public void getResult(List<Integer> candidate, String tmpResult, int curCount) {
        if (curCount == 4 && (finalResult.equals("") || finalResult.compareTo(tmpResult) < 0)) {
            finalResult = tmpResult;
            return;
        }
        for (int i = 0; i < candidate.size(); i++) {
            Integer integer = candidate.remove(i);
            if (curCount == 0 && integer <= 2) {
                getResult(candidate, tmpResult + integer, curCount + 1);
            } else if (curCount == 1 && (tmpResult.charAt(0) <= '1' || integer <= 3)) {
                getResult(candidate, tmpResult + integer + ":", curCount + 1);
            } else if (curCount == 2 && integer <= 5) {
                getResult(candidate, tmpResult + integer, curCount + 1);
            } else if (curCount == 3) {
                getResult(candidate, tmpResult + integer, curCount + 1);
            }
            candidate.add(i, integer);
        }
    }

    @Test
    public void test() {

    }
}
