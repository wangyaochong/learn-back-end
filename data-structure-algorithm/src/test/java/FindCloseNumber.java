import org.junit.Test;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindCloseNumber {
    //找到原数字差距最小的对称的数字

    @Test
    public void test() {

    }

    public int findNumber(int i) {
        if (i < 10) {
            return i;
        }
        if (i == 10) {
            return 9;
        } else if (i > 10) {

        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int length = s.length() / 2;
        String preHalf = s.substring(0, length);
        String postHalf = s.substring(length, s.length());
        String charMid = "";
        if (preHalf.length() != postHalf.length()) {
            charMid = charMid + postHalf.charAt(0);
            postHalf = postHalf.substring(1, postHalf.length());
        }
        //  System.out.println(charMid);
        String result1 = preHalf + charMid + reverse(preHalf);
        String result2 = reverse(postHalf) + charMid + postHalf;
        Long diff1 = Math.abs(Long.parseLong(result1) - Long.parseLong(s));
        Long diff2 = Math.abs(Long.parseLong(result2) - Long.parseLong(s));
        if (diff1 < diff2) {
            System.out.println(result1);
        } else {
            System.out.println(result2);
        }

    }

    public static String reverse(String input) {
        String result = "";
        int length = input.length();
        for (int i = 0; i < input.length(); i++) {
            result += input.charAt(length - i - 1);
        }
        return result;
    }

}
