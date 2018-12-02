package leetcode.byNumber;

import org.junit.Test;

import javax.swing.event.HyperlinkEvent;

public class p28_ImplementstrStr {

    @Test
    public void test(){
        System.out.println(strStr("121234", "123"));
    }

    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
         for(int i=0;i<haystack.length();i++){
             int count=0;
             for(int j=0;j<needle.length();j++){
                 if(i+j< haystack.length()&& haystack.charAt(i+j)==needle.charAt(j)){
                     count++;
                 }
             }
             if(count==needle.length()){
                 return i;
             }
         }
         return -1;
    }

}
