package leetcode;

import org.junit.Test;

public class p12_IntegertoRoman {

    @Test
    public void test(){
        System.out.println(intToRoman(15));
    }
    public String intToRoman(int num) {
        String[] dig=  new String[]{"", "I","II","III","IV","V","VI","VII","VIII","IV","IX"};
        String[] dig2=new String[]{ "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] dig3=new String[]{ "","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] dig4=new String[]{ "","M","MM","MMM","MMM"};
        return dig4[num/1000]+dig3[(num%1000)/100]+dig2[(num%100)/10]+dig[num%10];
    }
}
