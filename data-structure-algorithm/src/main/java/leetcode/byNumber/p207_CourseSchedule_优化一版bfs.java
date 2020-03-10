package leetcode.byNumber;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class p207_CourseSchedule_优化一版bfs {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            matrix[prerequisite[1]][prerequisite[0]] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {//如果说这门课不依赖任何课程
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
    }

}
