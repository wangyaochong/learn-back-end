package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p22_GenerateParentheses {
    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        getResult(result,"",n,n);
        return result;
    }
    public void getResult(List<String> result, String current,int leftCount,int rightCount){
        if(leftCount==0&&rightCount==0){
            result.add(current);
        }
        if(leftCount>0){
            getResult(result,current+"(",leftCount-1,rightCount);
        }
        if(leftCount<rightCount &&rightCount>0){
            getResult(result,current+")",leftCount,rightCount-1);
        }
    }
}
