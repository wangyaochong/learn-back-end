package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        getResult(new StringBuilder(s), 4, new StringBuilder(), result);
        return result;
    }

    public void getResult(StringBuilder left, int count, StringBuilder current, List<String> result) {
        if (left.length() > count * 3) {
            return;
        }
        if (count == 0) {
            if (left.length() == 0) {
                result.add(current.toString());
            }
            return;
        }
        if (left.length() >= 1) {
            StringBuilder currentCp = new StringBuilder(current);
            StringBuilder stringBuilder = new StringBuilder(left);
            currentCp.append(left.subSequence(0, 1));
            if (count != 1) {
                currentCp.append('.');
            }
            getResult(stringBuilder.delete(0, 1), count - 1, currentCp, result);
        }
        if (left.length() >= 2 && !left.substring(0, 1).startsWith("0")) {
            StringBuilder currentCp = new StringBuilder(current);
            StringBuilder stringBuilder2 = new StringBuilder(left);
            currentCp.append(left.subSequence(0, 2));
            if (count != 1) {
                currentCp.append('.');
            }
            getResult(stringBuilder2.delete(0, 2), count - 1, currentCp, result);
        }
        if (left.length() >= 3 && !left.substring(0, 3).startsWith("0")) {
            StringBuilder currentCp = new StringBuilder(current);
            StringBuilder stringBuilder3 = new StringBuilder(left);
            currentCp.append(left.subSequence(0, 3));
            if (left.subSequence(0, 3).toString().compareTo("255") > 0) {
                return;
            }
            if (count != 1) {
                currentCp.append('.');
            }
            getResult(stringBuilder3.delete(0, 3), count - 1, currentCp, result);
        }
    }

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("11111111"));
    }

}
