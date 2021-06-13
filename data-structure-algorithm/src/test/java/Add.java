import org.junit.Test;

import java.util.Scanner;

public class Add {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(addOne(s));
    }

    public static String addOne(String strNumber) {
        String[] split = strNumber.split(",");
        int[] number = new int[split.length + 1];
        for (int i = 1; i < number.length; i++) {
            number[i] = Integer.parseInt(split[i - 1]);
        }
        int i = number.length - 1;
        int carry = 0;
        int carryCache;

        do {
            carryCache = (number[i] + 1 + carry) / 10;
            if (i == number.length - 1) {
                number[i] = (number[i] + 1 + carry) % 10;
            } else {
                number[i] = (number[i] + carry) % 10;
            }
            carry = carryCache;
            i--;
        } while (carry != 0);
        StringBuilder result = new StringBuilder();

        int start = 0;
        if (number[0] == 0) {
            start = 1;
        }
        for (int loc = start; loc < number.length; loc++) {
            result.append(number[loc]);
            result.append(",");
        }
        return result.toString();
    }

    @Test
    public void test() {
        String s = addOne("1,2,3");
        String s1 = addOne("1,2,9");
        String s2 = addOne("9,9");
    }

}
