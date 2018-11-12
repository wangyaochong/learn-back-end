package leetcode;

import org.junit.Test;

public class p44_WildcardMatching_未完成 {
    public boolean isMatch(String s, String p) {
        boolean [][] flag= new boolean[s.length()+1][p.length()+1];
        flag[0][0]=true;

        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='?'){
                    flag[i+1][j+1]=flag[i][j];
                }
                else if(p.charAt(j)=='*'){
                    flag[i+1][j+1]=(
                                    flag[i+1][j] ||//匹配0个字符
                                    flag[i][j] ||//匹配一个字符
                                    flag[i][j+1] );//匹配多个字符
//                    flag[i][j+1]=flag[i][j];
                }else {
                    flag[i+1][j+1]=flag[i][j]&&s.charAt(i)==p.charAt(j);
                }
            }
        }

        return flag[s.length()][p.length()];
    }
    @Test
    public void test(){
        System.out.println(isMatch("adddceeb", "*a*b"));
    }
}
