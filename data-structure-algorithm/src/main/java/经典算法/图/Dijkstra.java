package 经典算法.图;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
    public void solve(int[][] map, int start) {
        Set<Integer> visited = new HashSet<>();
        //初始化distance，除了直接相连的，其他节点距离是无穷远
        int inf = Integer.MAX_VALUE;
        int[] distance = new int[map.length];
        Arrays.fill(distance, inf);
        for (int i = 0; i < map.length; i++) {
            if (map[start][i] != inf) {
                distance[i] = map[start][i];
            }
        }
        while (visited.size() + 1 < map.length) {
            int minDis = Integer.MAX_VALUE;
            int minLoc = 0;
            //从未访问列表中找出距离起点最短的点
            for (int i = 0; i < map.length; i++) {
//                没有访问过的，不是自己，距离最近
                if (!visited.contains(i) && i != start && distance[i] < minDis) {
                    minDis = distance[i];
                    minLoc = i;
                }
            }
            visited.add(minLoc);
            for (int i = 0; i < map.length; i++) {
                //不可达或者终点是start的情况不处理
                if (map[minLoc][i] != inf && start != i) {
                    //到i的最短路径，要么是以前求出来的，要么是两条新的边的和
                    distance[i] = Math.min(distance[minLoc] + map[minLoc][i], distance[i]);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    @Test
    public void test() {
        int inf = Integer.MAX_VALUE;
//正确答案
// [7, 12, 0, 17, 8, 13, 9]
// [2, 3, 9, 10, 4, 6, 0]
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
        solve(map, 2);
        solve(map, 6);
    }
}
