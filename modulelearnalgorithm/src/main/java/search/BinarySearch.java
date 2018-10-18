package search;

import org.junit.Test;

public class BinarySearch {
    @Test
    public void test(){
        System.out.println(search(new int[]{1, 2}, 2));
    }
    public int search(int[] list,int target){
        int low=0;
        int high=list.length-1;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            if(list[mid]<target){
                low=mid+1;
            }else if(list[mid]>target){
                high=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
