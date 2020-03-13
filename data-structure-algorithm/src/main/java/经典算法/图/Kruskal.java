package 经典算法.图;

import org.junit.Test;
import 经典算法.图.def.Edge;

import java.util.*;

/**
 * 需要排序、需要判断是否有环
 */
public class Kruskal {


    public void solve(int[][] map) {
        List<Edge> edgeList = new ArrayList<>();
        List<Edge> result = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] != 0 && i < j) {
                    Edge edge = new Edge(i, j, j, map[i][j]);
                    edgeList.add(edge);
                }
            }
        }
        edgeList.sort(Comparator.comparingInt(Edge::getWeight));
        Set<Integer> point = new HashSet<>();
        //可以直接加入一条边
        result.add(edgeList.remove(0));
        while (point.size() < map.length) {
            Edge remove = edgeList.remove(0);
            int startFinalEnd = -1;
            int endFinalEnd = -1;
            for (Edge edge : result) {
                if (remove.getStart() == edge.getStart() || remove.getStart() == edge.getEnd()) {
                    startFinalEnd = Math.max(edge.getFinalEnd(), remove.getFinalEnd());
                }
                if (remove.getEnd() == edge.getStart() || remove.getEnd() == edge.getEnd()) {
                    endFinalEnd = Math.max(edge.getFinalEnd(), remove.getFinalEnd());
                }
            }
            if (startFinalEnd == -1 && endFinalEnd == -1 || startFinalEnd != endFinalEnd) {
                point.add(remove.getStart());
                point.add(remove.getEnd());
                if (endFinalEnd != -1) {
                    remove.setFinalEnd(Math.max(startFinalEnd, endFinalEnd));
                }
                for (Edge edge : result) {
                    if (edge.getStart() == remove.getStart() ||
                            edge.getStart() == remove.getEnd() ||
                            edge.getEnd() == remove.getStart() ||
                            edge.getEnd() == remove.getEnd()) {
                        //接入后需要更新之前的edge的终点指向
                        edge.setFinalEnd(Math.max(remove.getFinalEnd(), edge.getFinalEnd()));
                    }
                }
                result.add(remove);
            }
        }
        for (Edge edge : result) {
            System.out.println(edge);
        }
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

}
