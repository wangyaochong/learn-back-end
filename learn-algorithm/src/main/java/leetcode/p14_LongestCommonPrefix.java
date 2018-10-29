package leetcode;

import org.junit.Test;

public class p14_LongestCommonPrefix {
    @Test
    public void test(){

    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int currentLoc=0;
        StringBuilder stringBuilder=new StringBuilder();
        char curChar=' ';
        while(true){
            int sameCount=0;
            for(int i=0;i<strs.length;i++){
                if(i==0&&currentLoc<strs[i].length()){
                    curChar=strs[i].charAt(currentLoc);
                }else if(currentLoc<strs[i].length()&&curChar==strs[i].charAt(currentLoc)){
                }else{
                    break;
                }
                sameCount++;
            }
            if(sameCount==strs.length){
                stringBuilder.append(curChar);
            }else{
                break;
            }
            currentLoc++;
        }
        return stringBuilder.toString();
    }
}
