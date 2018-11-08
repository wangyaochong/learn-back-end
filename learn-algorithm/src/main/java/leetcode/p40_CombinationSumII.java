package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p40_CombinationSumII {//一个数字（同一个下标）只能使用一次
    @Test
    public void test(){
        List<List<Integer>> lists = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        getResult(candidates,target,result,new ArrayList<>(),0);
        return result;
    }

    public void getResult(int [] candidates,int target,List<List<Integer>> totalResult,List<Integer> curResult,int curLoc){

        if(target==0){
            totalResult.add(new ArrayList<>(curResult));
            return ;
        }

        int i=curLoc;
        while(i<candidates.length){
            if(target>=candidates[i]){
                if(curResult.size()==0 || curResult.get(curResult.size()-1)<=candidates[i]){
                    curResult.add(candidates[i]);
                    getResult(candidates,target-candidates[i],totalResult,curResult,i+1);
                    curResult.remove(curResult.size()-1);
                }
            }
            while(i+1<candidates.length&&candidates[i]==candidates[i+1]){
                i++;
            }
            i++;
        }
    }
}
