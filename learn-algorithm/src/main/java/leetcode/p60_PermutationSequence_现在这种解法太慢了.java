package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p60_PermutationSequence_现在这种解法太慢了 {
    @Test
    public void test() {
        System.out.println(getPermutation(4, 9));
    }

    @Test
    public void testClassForName() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(Class.forName("java.lang.Integer").newInstance());
        ArrayList<Object> o = (ArrayList<Object>) Class.forName("java.util.ArrayList").newInstance();
        o.add("1");
        System.out.println(o);
        System.out.println();
    }


    public String getPermutation(int n, int k) {
        List<Character> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candidates.add((char) ('1' + i));
        }
        getResult(candidates, new ArrayList<>(), n, k);
        StringBuilder builder = new StringBuilder();
        for (Character character : characters) {
            builder.append(character);
        }
        return builder.toString();
    }

    Integer count = 0;
    List<Character> characters;

    public void getResult(List<Character> candidates, List<Character> curResult, int n, int k) {
        if (curResult.size() == n) {
            count++;
            characters = new ArrayList<>(curResult);
            return;
        }
        if (count >= k) {
            return;
        }
        for (int i = 0; i < candidates.size(); i++) {
            Character remove = candidates.remove(i);
            curResult.add(remove);
            getResult(candidates, curResult, n, k);
            curResult.remove(curResult.size() - 1);
            candidates.add(i, remove);
        }
    }
}
