package 经典算法.练习.马踏棋盘;

import org.junit.Test;
import util.UtilArray;

public class 马踏棋盘基础版 {

    public void solve(int[][] map, int x, int y, int count) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length || map[x][y] != 0) {
            return;
        }
        count++;
        map[x][y] = count;
        if (count == map.length * map.length) {
            UtilArray.display(map);
            System.out.println("-------------------------");
        }
        solve(map, x - 1, y - 2, count);
        solve(map, x - 2, y - 1, count);
        solve(map, x + 1, y + 2, count);
        solve(map, x + 2, y + 1, count);
        solve(map, x - 1, y + 2, count);
        solve(map, x - 2, y + 1, count);
        solve(map, x + 1, y - 2, count);
        solve(map, x + 2, y - 1, count);
        map[x][y] = 0;
    }


    @Test
    public void test() {
        int mapWidth = 8;
        solve(new int[mapWidth][mapWidth], 4, 4, 0);
    }
}
