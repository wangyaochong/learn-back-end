package 经典算法.练习.马踏棋盘;

import leetcode.base.definition.Point;
import org.junit.Test;
import util.UtilArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 马踏棋盘升级版 {

    public void solve(int[][] map, int x, int y, int count) {
        count++;
        map[x][y] = count;
        if (count == map.length * map.length) {
            UtilArray.display(map);
            System.out.println("-------------------------");
        }
        List<Point> nextPointList = getNextPointList(x, y, map);
        //排序是重点，集中力量办事，不排序结果都出不了
        nextPointList.sort(Comparator.comparingInt(o -> getNextPointList(o.getX(), o.getY(), map).size()));
        for (Point point : nextPointList) {
            solve(map, point.getX(), point.getY(), count);
        }
        map[x][y] = 0;
    }

    public List<Point> getNextPointList(int x, int y, int[][] map) {
        List<Point> pointList = new ArrayList<>();
        if (x - 1 >= 0 && y - 2 >= 0 && map[x - 1][y - 2] == 0) {
            pointList.add(new Point(x - 1, y - 2));
        }
        if (x - 2 >= 0 && y - 1 >= 0 && map[x - 2][y - 1] == 0) {
            pointList.add(new Point(x - 2, y - 1));
        }
        if (x + 1 < map.length && y + 2 < map.length && map[x + 1][y + 2] == 0) {
            pointList.add(new Point(x + 1, y + 2));
        }
        if (x + 2 < map.length && y + 1 < map.length && map[x + 2][y + 1] == 0) {
            pointList.add(new Point(x + 2, y + 1));
        }
        if (x - 1 >= 0 && y + 2 < map.length && map[x - 1][y + 2] == 0) {
            pointList.add(new Point(x - 1, y + 2));
        }
        if (x - 2 >= 0 && y + 1 < map.length && map[x - 2][y + 1] == 0) {
            pointList.add(new Point(x - 2, y + 1));
        }
        if (x + 1 < map.length && y - 2 >= 0 && map[x + 1][y - 2] == 0) {
            pointList.add(new Point(x + 1, y - 2));
        }
        if (x + 2 < map.length && y - 1 >= 0 && map[x + 2][y - 1] == 0) {
            pointList.add(new Point(x + 2, y - 1));
        }
        return pointList;
    }


    @Test
    public void test() {
        int mapWidth = 8;
        solve(new int[mapWidth][mapWidth], 1, 1, 0);
    }
}
