package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p936_MoveToStamp_超时失败 {
    @Test
    public void test() {
        result = new ArrayList<>();
        int[] ints3 = movesToStamp("qr", "qrqqqrqrqrrqrqr");
        System.out.println(Arrays.toString(ints3));
//
//        result = new ArrayList<>();
//        int[] ints = movesToStamp("abc", "ababc");
//        System.out.println(Arrays.toString(ints));
//
//        result = new ArrayList<>();
//        int[] ints2 = movesToStamp("abca", "aabcaca");
        //abca???
        //ababca?
        //abaabca
        //aabcaca
        //System.out.println(Arrays.toString(ints2));
    }

    public int[] movesToStamp(String stamp, String target) {
        if (!target.contains(stamp)) {
            return new int[0];
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < target.length(); i++) {
                stringBuilder.append("?");
            }
            solve(new ArrayList<>(), stamp, stringBuilder.toString(), target, target.length() * 10);
        }
        if (result.size() == 0) {
            return new int[0];
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

    List<Integer> result = new ArrayList<>();

    public void solve(List<Integer> currentStep, String stamp, String current, String target, int leftCount) {
        if (result.size() != 0) {
            return;
        }
        if (current.equals(target)) {
            result.addAll(currentStep);
            return;
        }
        if (leftCount == 0) {
            return;
        }
        int i1 = current.length() - stamp.length();
        for (int i = 0; i <= i1; i++) {
            if (!currentStep.contains(i)) {
                String substring = current.substring(i, i + stamp.length());
                if(substring.equals(stamp)){//如果相同，不处理
                    continue;
                }
                currentStep.add(i);
                StringBuilder stringBuilder = new StringBuilder(current);
                StringBuilder replace = stringBuilder.replace(i, i + stamp.length(), stamp);
                solve(currentStep, stamp, replace.toString(), target, leftCount - 1);
                currentStep.remove(currentStep.size() - 1);
            }

        }
    }
}
