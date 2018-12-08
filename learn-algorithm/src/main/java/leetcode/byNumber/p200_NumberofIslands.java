package leetcode.byNumber;

import org.junit.Test;

public class p200_NumberofIslands {

    int islandCount = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    search(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public void search(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            search(grid, x - 1, y);
        }
        if (x + 1 < grid.length && grid[x + 1][y] ==  '1') {
            search(grid, x + 1, y);
        }
        if (y - 1 >= 0 && grid[x][y - 1] ==  '1') {
            search(grid, x, y - 1);
        }
        if (y + 1 < grid[0].length && grid[x][y + 1] ==  '1') {
            search(grid, x, y + 1);
        }
    }

    @Test
    public void test() {

    }
}
