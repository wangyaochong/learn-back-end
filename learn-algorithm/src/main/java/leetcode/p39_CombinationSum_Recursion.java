package leetcode;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p39_CombinationSum_Recursion {//允许一个数字使用多次
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        getResult(candidates,target,result,new ArrayList<>());
        return result;
    }
    public void getResult(int[] candidates,int target,List<List<Integer>> result,List<Integer> curResult){
        if(target==0){
            result.add(new ArrayList<>(curResult));
            return;
        }
        for (int candidate : candidates) {
            if (target >= candidate) {
                if (curResult.size() == 0 || candidate >= curResult.get(curResult.size() - 1)) {
                    curResult.add(candidate);
                    getResult(candidates, target - candidate, result, curResult);
                    curResult.remove(curResult.size() - 1);
                }
            } else {
                break;
            }
        }
    }

    @Test
    public void test(){
//        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
//        System.out.println(lists);

        List<List<Integer>> lists = combinationSum(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
    }




}
