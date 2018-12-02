package leetcode.byNumber;

import org.junit.Test;

public class p9_PalindromeNumber2 {

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int reverse=0;
        while(reverse<x){
            reverse=x%10+reverse*10;
            x=x/10;
        }
        return (reverse==x)||(reverse/10==x);
    }
    @Test
    public void test(){
        System.out.println(isPalindrome(1221));
    }
}
