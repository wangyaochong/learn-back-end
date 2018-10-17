package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p17_LetterCombinationsofaPhoneNumber {
    @Test
    public void test(){
        System.out.println(letterCombinations("23"));

    }
    char [][] numChar=new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            result= combination(result,numChar[Integer.parseInt(Character.toString(digits.charAt(i)))]);
        }
        return result;
    }

    public List<String> combination(List<String> origin, char[] candidate){
        List<String> result=new ArrayList<>();
        if(origin.size()==0){
            for(char c: candidate){
                result.add(Character.toString(c));
            }
        }else{
            for (String s : origin) {
                for (char c : candidate) {
                    result.add(s+Character.toString(c));
                }
            }
        }
        return result;
    }
}
