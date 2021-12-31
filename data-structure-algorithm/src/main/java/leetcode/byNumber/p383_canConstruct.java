package leetcode.byNumber;

import org.junit.Test;

public class p383_canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] flag = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            flag[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            flag[ransomNote.charAt(i) - 'a']--;
        }
        for (int i : flag) {
            if(i<0){
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void test(){
        System.out.println(canConstruct("abcss", "abxcs"));
    }
}
