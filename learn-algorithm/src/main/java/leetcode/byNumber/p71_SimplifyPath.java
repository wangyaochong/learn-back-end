package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class p71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        List<String> cache = new ArrayList<>();
        for (String aSplit : split) {
            if (aSplit.equals("")) {
                continue;
            }
            if (Objects.equals(aSplit, "..")) {
                if (!cache.isEmpty()) {
                    cache.remove(cache.size() - 1);
                }
            } else if (!aSplit.equals(".")) {
                cache.add(aSplit);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String s : cache) {
            result.append("/").append(s);
        }
        if (result.length() == 0) {
            return "/";
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
