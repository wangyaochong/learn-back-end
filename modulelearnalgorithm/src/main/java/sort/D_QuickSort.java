package sort;

import org.junit.Test;
import util.UtilArray;

public class D_QuickSort {

    @Test
    public void test(){
        int[] array = {1, 2, 3, 4, 2, 3, 5};
        quickSort(array,0,array.length-1);
        UtilArray.display(array);
    }

    public void quickSort(int [] array,int i,int j){
        if(i>=j){
            return ;
        }
        int mid=partition(array,i,j);
        quickSort(array,i,mid-1);
        quickSort(array,mid+1,j);
    }

    public int partition(int[] array,int i,int j){
        int flag=array[i];
        while(i<j){
            while(i<j&&array[j]>=flag){
                j--;
            }
            array[i]=array[j];
            while (i<j&&array[i]<=flag){
                i++;
            }
            array[j]=array[i];
        }
        array[i]=flag;
        return i;
    }
}
