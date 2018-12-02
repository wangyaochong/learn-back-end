package leetcode.byNumber;

import org.junit.Test;

public class p38_CountandSay {
    @Test
    public void test(){
        System.out.println(countAndSay(1));
    }
    public String solve(String current,int count){
        if(count>0){
            StringBuilder stringBuilder=new StringBuilder();
            int loc=0;
            int i=1;
            while(loc<current.length()){
                while(loc+1<current.length()&&current.charAt(loc)==current.charAt(loc+1)){
                    i++;
                    loc++;
                }
                stringBuilder.append(i);
                stringBuilder.append(current.charAt(loc));
                i=1;
                loc++;
            }
            return solve(stringBuilder.toString(),count-1);
        }else{
            return current;
        }
    }

    public String countAndSay(int n) {
        return solve("1",n-1);
    }

    /**
     * String会比StringBuilder慢很多
     * @param current
     * @param count
     * @return
     */
    public String solve2(String current,int count){
        if(count>0){
            String string=new String();
            int loc=0;
            int i=1;
            while(loc<current.length()){
                while(loc+1<current.length()&&current.charAt(loc)==current.charAt(loc+1)){
                    i++;
                    loc++;
                }
                string+=(i);
                string+=(current.charAt(loc));
                i=1;
                loc++;
            }
            return solve2(string,count-1);
        }else{
            return current;
        }
    }
}
