package leetcode.byNumber;

public class p58_LengthofLastWord {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int count = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }

        return count;
    }

    public int lengthOfLastWord2(String s) {

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}
