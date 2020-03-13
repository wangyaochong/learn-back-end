package 经典算法.图;

import org.junit.Test;
import util.UtilArray;

import java.util.HashSet;
import java.util.Set;

/**
 * Prim是扩张算法
 * 随机选择一个点，选出这个点的关联的的【最短边】，
 * 在访问列表中加入这条边的两个点，从这两个点开始【扩张】构造最小生成树
 */
public class Prim {


    public int[][] solve(int[][] map) {
        UtilArray.display(map);
        Set<Integer> visited = new HashSet<>();
        int[][] shortMap = new int[map.length][map.length];
        int shortLen = Integer.MAX_VALUE;
        int shortI = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i][0] != 0 && map[i][0] < shortLen) {
                //先随机这个节点关联的边的最短的两个点
                shortLen = map[i][0];
                shortI = i;
            }
        }
        visited.add(shortI);
        visited.add(0);
        shortMap[shortI][0] = map[shortI][0];
        shortMap[0][shortI] = map[shortI][0];
//        从节点开始扩散
        while (visited.size() < map.length) {
            int minLength = Integer.MAX_VALUE;
            int mx = 0;
            int my = 0;
            for (Integer integer : visited) {
                for (int i = 0; i < map.length; i++) {
                    if (map[i][integer] != 0 && minLength > map[i][integer] && !(visited.contains(i) && visited.contains(integer))) {
                        minLength = map[i][integer];
                        mx = i;
                        my = integer;
                    }
                }
            }
            visited.add(mx);
            visited.add(my);
            shortMap[mx][my] = map[mx][my];
            shortMap[my][mx] = map[mx][my];
        }


        System.out.println("----------------------------");
        UtilArray.display(shortMap);
        int sum = 0;
        for (int i = 0; i < shortMap.length; i++) {
            for (int j = 0; j < shortMap.length; j++) {
                sum += shortMap[i][j];
            }
        }
        System.out.println("总权重=" + sum / 2);
        return shortMap;
    }

    @Test
    public void test() {
        int[][] map = new int[][]{
                {0, 5, 7, 0, 0, 0, 2},
                {5, 0, 0, 9, 0, 0, 3},
                {7, 0, 0, 0, 8, 0, 0},
                {0, 9, 0, 0, 0, 4, 0},
                {0, 0, 8, 0, 0, 5, 4},
                {0, 0, 0, 4, 5, 0, 6},
                {2, 3, 0, 0, 4, 6, 0},
        };
        solve(map);
    }


//Kruskal.Edge(start=0, end=6, finalEnd=6, weight=2)
//Kruskal.Edge(start=1, end=6, finalEnd=6, weight=3)
//Kruskal.Edge(start=3, end=5, finalEnd=5, weight=4)
//Kruskal.Edge(start=4, end=6, finalEnd=6, weight=4)
//Kruskal.Edge(start=4, end=5, finalEnd=5, weight=5)
//Kruskal.Edge(start=0, end=2, finalEnd=2, weight=7)
}
