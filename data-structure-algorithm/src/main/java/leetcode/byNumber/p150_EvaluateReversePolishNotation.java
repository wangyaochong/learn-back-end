package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p150_EvaluateReversePolishNotation {

    @Test
    public void test() {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {

        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                Integer remove1 = number.remove(number.size() - 1);
                Integer remove2 = number.remove(number.size() - 1);
                number.add(remove1 + remove2);
            } else if (tokens[i].equals("-")) {
                Integer remove1 = number.remove(number.size() - 1);
                Integer remove2 = number.remove(number.size() - 1);
                number.add(remove2 - remove1);
            } else if (tokens[i].equals("*")) {
                Integer remove1 = number.remove(number.size() - 1);
                Integer remove2 = number.remove(number.size() - 1);
                number.add(remove2 * remove1);
            } else if (tokens[i].equals("/")) {
                Integer remove1 = number.remove(number.size() - 1);
                Integer remove2 = number.remove(number.size() - 1);
                number.add(remove2 / remove1);
            } else {
                number.add(Integer.valueOf(tokens[i]));
            }
        }
        return number.get(0);
    }


}
