package leetcode;

import org.junit.Test;

public class p11_ContainerWithMostWater {
    @Test
    public void test(){

    }
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        int tmp=0;
        while(left<right){
            tmp=Math.min(height[left],height[right])*(right-left);
            if(max<tmp){
                max=tmp;
            }
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
