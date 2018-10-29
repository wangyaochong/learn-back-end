package sort;

import org.junit.Test;
import util.UtilArray;

public class B_InsertSort {
    @Test
    public void test(){
        int[] array = {2, 1, 3, 4, 2, 3, 5};
        sort(array);
        UtilArray.display(array);
    }

    public void sort(int[] array){
        for(int i=1;i<array.length;i++){
            int j=i;
            int flag=array[i];
            while(j>0&& flag<array[j-1]){
                array[j]=array[j-1];
                j--;
            }
            array[j]=flag;
        }
    }
}
