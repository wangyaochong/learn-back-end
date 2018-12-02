package leetcode.byNumber;

import org.junit.Test;

public class p7_ReverseInteger {
    @Test
    public void test(){
        int reverse = reverse(-100);
        System.out.println(reverse);
    }
    public int reverse(int x) {
        int result=0;
        while(x!=0){
            result=(x%10+result*10);
            x=x/10;
        }
        return result;
    }
}
