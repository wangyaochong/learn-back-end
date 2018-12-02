package leetcode.byNumber;

import org.junit.Test;
import util.UtilArray;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class p41_FirstMissingPositive_这道题要多看 {

    public static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            //第0个位置放1，依次类推，放到正确的位置，如果说nums[i]-1这个下标上的数已经正确(=nums[i])，则可以跳过这个下标
            //如果换完位置后，依然满足条件，则还可以交换位置，知道交换过的数字超出范围，则这个数字可以不用处理了
            if(nums[i]>0&&nums[i]<=nums.length&& nums[nums[i]-1] != nums[i]){
                swap(nums,i,nums[i]-1);
                i--;
            }
        }

        int len=nums.length;
        int number=1;
        while(number-1<len&&number==nums[number-1]){
            number++;
        }
        return number;
    }

    @Test
    public void test() {
        int i = firstMissingPositive(new int[]{-1,0,-3,2,2,1,1,3,3,3,2,2});
        System.out.println(i);
    }
}
