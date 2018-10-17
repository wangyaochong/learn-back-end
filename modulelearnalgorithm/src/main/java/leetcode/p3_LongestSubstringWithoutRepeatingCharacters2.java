package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class p3_LongestSubstringWithoutRepeatingCharacters2 {

    @Test
    public void test(){

    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> charLoc=new HashMap<>();
        int max=0;
        for(int i=0,j=0;i<s.length();i++){
            if(charLoc.containsKey(s.charAt(i))){
                Integer loc = charLoc.get(s.charAt(i));
                j=Math.max(j,loc+1);
            }
            max=Math.max(max,i-j+1);
            charLoc.put(s.charAt(i),i);
        }
        return max;
    }
}
