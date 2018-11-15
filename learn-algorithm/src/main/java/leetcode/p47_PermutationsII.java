package leetcode;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class p47_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<List<Integer>> result=new ArrayList<>();
        getResult(list,new ArrayList<>(),result);
        return result;
    }
    public void getResult(List<Integer> list,List<Integer> curResult,List<List<Integer>> result){
        if(list.size()==0){
            result.add(new ArrayList<>(curResult));
            return ;
        }
        int i=0;
        while(i<list.size()){
            while(i+1<list.size()&&list.get(i).equals(list.get(i+1))){
                i++;
            }
            Integer remove = list.remove(i);
            curResult.add(remove);
            getResult(list,curResult,result);
            curResult.remove(curResult.size()-1);
            list.add(i,remove);
            i++;
        }
    }
    @Test
    public void test(){
        List<List<Integer>> permute = permuteUnique(new int[]{1,1,2});
        System.out.println(permute);
    }

    @Test
    public void test2(){
        System.out.println(DateFormatUtils.format(new Date(0),"yyyy-MM-dd HH:mm:ss"));
    }
}
