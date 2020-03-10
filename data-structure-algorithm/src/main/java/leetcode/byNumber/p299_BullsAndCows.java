package leetcode.byNumber;

import org.junit.Test;

public class p299_BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] bullArray = new int[10];
        int[] secretCount = new int[10];
        int[] gussCount = new int[10];
        for (int i = 0; i < guess.length(); i++) {
            secretCount[secret.charAt(i) - '0']++;
            gussCount[guess.charAt(i) - '0']++;
            if (secret.charAt(i) == guess.charAt(i)) {
                bullArray[secret.charAt(i) - '0']++;//记录位置相同且字符相同的数量
            }
        }
        int bullCount = 0;
        int cowCount = 0;
        for (int i = 0; i < 10; i++) {
            bullCount += bullArray[i];
            cowCount += Math.min(secretCount[i], gussCount[i]) - bullArray[i];
        }
        return String.valueOf(bullCount) + 'A' + cowCount + 'B';
    }

    @Test
    public void test() {
        System.out.println(getHint("1807", "7810"));
    }

}

