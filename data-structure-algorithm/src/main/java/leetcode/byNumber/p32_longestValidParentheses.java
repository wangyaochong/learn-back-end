package leetcode.byNumber;

import org.junit.Test;

import java.util.Stack;

public class p32_longestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> cache = new Stack<>();
        int count=0;
        cache.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                cache.push(i);
            }else{
                cache.pop();
                if(cache.size()>0){
                    count = Math.max(count, i - cache.peek());
                }else{
                    cache.push(i);
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
//        System.out.println(longestValidParentheses("()(()()"));
        System.out.println(longestValidParentheses("()()"));
    }
}
