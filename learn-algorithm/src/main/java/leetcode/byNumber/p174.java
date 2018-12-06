package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p174 {

    public int calculateMinimumHP(int[][] dungeon) {
        getResult(dungeon, 0, 0, 0, 0);
        if (minHp > 0) {
            return 0;
        } else {
            return 0 - minHp + 1;
        }
    }

    private int minHp = Integer.MIN_VALUE;

    public void getResult(int[][] dungeon, int x, int y, int curBlood, int currentMin) {
        if (minHp < currentMin && currentMin < 0) {
            minHp = currentMin;
        }
        if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
            int min = Math.min(dungeon[x][y], dungeon[x][y] + curBlood);
            if (minHp < min && min < 0) {
                minHp = min;
            }
            return;
        }
        if (x + 1 < dungeon.length) {
            getResult(dungeon, x + 1, y, dungeon[x][y] + curBlood, Math.min(currentMin, dungeon[x][y] + curBlood));
        }
        if (y + 1 < dungeon[0].length) {
            getResult(dungeon, x, y + 1, dungeon[x][y] + curBlood, Math.min(currentMin, dungeon[x][y] + curBlood));
        }
    }

    @Test
    public void test() {
        int[][] ints = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(ints));
        System.out.println(Arrays.deepToString(ints));
    }

}
