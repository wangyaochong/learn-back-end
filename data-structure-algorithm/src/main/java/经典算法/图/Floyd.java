package 经典算法.图;

import org.junit.Test;
import util.UtilArray;

public class Floyd {

    public void solve(int[][] map) {
        for (int k = 0; k < map.length; k++) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        UtilArray.display(map);
    }

    @Test
    public void test() {
        int inf = Integer.MAX_VALUE / 3;
//正确答案  [2, 3, 9, 10, 4, 6, 0]
//        自己到自己的距离是0
        int[][] map = new int[][]{
                {0, 5, 7, inf, inf, inf, 2},
                {5, 0, inf, 9, inf, inf, 2},
                {7, inf, 0, inf, 8, inf, inf},
                {inf, 9, inf, 0, inf, 4, inf},
                {inf, inf, 8, inf, 0, 5, 4},
                {inf, inf, inf, 4, 5, 0, 6},
                {2, 3, inf, inf, 4, 6, 0},
        };
        solve(map);
    }

}
