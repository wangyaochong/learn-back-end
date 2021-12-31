package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p1073_addNegabinary {

    @Test
    public void test(){
        System.out.println(Arrays.toString(addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1})));
    }
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int sum = getNumber(arr1) + getNumber(arr2);
        if(sum>0){

        }
        return null;
    }

    public int getNumber(int[] arr) {
        int loc = arr.length - 1;
        int num = 0;
        int currentUnit = 1;
        while (loc >= 0) {
            num += currentUnit * arr[loc];
            currentUnit = currentUnit * -2;
            loc--;
        }
        return num;
    }

    @Test
    public void testGetNumber(){
        int number = getNumber(new int[]{1, 1, 0, 1});
        System.out.println(number);
    }

}
