package leetcode.byNumber;

import org.junit.Test;

import java.util.Stack;

public class p20_ValidParentheses {
    @Test
    public void test() {
        System.out.println(isValid("(())[]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack1 = new Stack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    stack1.push(s.charAt(i));
                }
                if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                    Character pop = stack1.pop();
                    if (s.charAt(i) == ')' && pop != '(' || s.charAt(i) == ']' && pop != '[' || s.charAt(i) == '}' && pop != '{') return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return stack1.isEmpty();
    }
}
