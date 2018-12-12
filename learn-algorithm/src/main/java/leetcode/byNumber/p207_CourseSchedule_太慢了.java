package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class p207_CourseSchedule_太慢了 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Boolean> onlyOut = new HashMap<>();
        Map<Integer, Boolean> inNode = new HashMap<>();
        List<int[]> list = Arrays.stream(prerequisites).collect(Collectors.toList());
        while (true) {
            for (int i = 0; i < list.size(); i++) {
                inNode.put(list.get(i)[1], true);
                onlyOut.remove(list.get(i)[1]);
                if (inNode.get(list.get(i)[0]) == null) {
                    onlyOut.put(list.get(i)[0], true);
                } else {
                    onlyOut.remove(list.get(i)[0]);
                }
            }
            if (onlyOut.size() != 0) {
                list.removeIf(next -> onlyOut.get(next[0]) != null);
                onlyOut.clear();
                inNode.clear();
            } else {
                return list.size() == 0;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
