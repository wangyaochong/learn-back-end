package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p471_pacificAtlantic_慢版本 {
    //  太平洋 ~   ~   ~   ~   ~
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
    @Test
    public void test() {
        List<List<Integer>> lists = pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
//        List<List<Integer>> lists = pacificAtlantic(new int[][]{{1,2},{1,2}});
        System.out.println(lists);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        int[][] t = new int[heights.length][heights[0].length];
        int[][] d = new int[heights.length][heights[0].length];
        int[][] visited = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                canToT(i, j, heights, t, visited);
                canToD(i, j, heights, d, visited);
                if (t[i][j] == 1 && d[i][j] == 1) {
                    ArrayList<Integer> e = new ArrayList<>();
                    e.add(i);
                    e.add(j);
                    result.add(e);
                }

            }
        }
        return result;
    }

    public boolean canToD(int x, int y, int[][] map, int[][] t, int[][] visited) {
        if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
            visited[x][y] = 1;
        }
        if (x == map.length - 1 || y == map[0].length - 1) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }

        if (x - 1 >= 0 && visited[x - 1][y] == 0 && map[x - 1][y] <= map[x][y] &&
                (t[x - 1][y] == 1 || canToD(x - 1, y, map, t, visited))) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }
        if (x + 1 < map.length && visited[x + 1][y] == 0 && map[x + 1][y] <= map[x][y] &&
                (t[x + 1][y] == 1 || canToD(x + 1, y, map, t, visited))) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }
        if (y - 1 >= 0 && visited[x][y - 1] == 0 && map[x][y - 1] <= map[x][y] &&
                (t[x][y - 1] == 1 || canToD(x, y - 1, map, t, visited))) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }
        if (y + 1 < map[0].length && visited[x][y + 1] == 0 && map[x][y + 1] <= map[x][y] &&
                (t[x][y + 1] == 1 || canToD(x, y + 1, map, t, visited))) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }
        visited[x][y] = 0;
        return false;
    }

    public boolean canToT(int x, int y, int[][] map, int[][] t, int[][] visited) {
        if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
            visited[x][y] = 1;
        }
        if (x == 0 || y == 0) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }

        if (x - 1 >= 0 && visited[x - 1][y] == 0 && map[x - 1][y] <= map[x][y] &&
                (t[x - 1][y] == 1 || canToT(x - 1, y, map, t, visited))) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }
        if (x + 1 < map.length && visited[x + 1][y] == 0 && map[x + 1][y] <= map[x][y] &&
                (t[x + 1][y] == 1 || canToT(x + 1, y, map, t, visited))) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }
        if (y - 1 >= 0 && visited[x][y - 1] == 0 && map[x][y - 1] <= map[x][y] && (
                t[x][y - 1] == 1 || canToT(x, y - 1, map, t, visited))) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }
        if (y + 1 < map[0].length && visited[x][y + 1] == 0 && map[x][y + 1] <= map[x][y] &&
                (t[x][y + 1] == 1 || canToT(x, y + 1, map, t, visited))) {
            t[x][y] = 1;
            visited[x][y] = 0;
            return true;
        }
        visited[x][y] = 0;
        return false;
    }
}
