package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p3_LongestSubstringWithoutRepeatingCharacters {
    @Test
    public void test(){

    }

    public int lengthOfLongestSubstring(String s) {
        int maxCount=0;
        List<Character> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int j=i;
            while(j<s.length()&&!list.contains(s.charAt(j))){
                list.add(s.charAt(j));
                j++;
            }
            if(list.size()>maxCount){
                maxCount=list.size();
            }
            list.clear();
        }
        return maxCount;
    }
}
