package Graph;

import java.util.LinkedList;
import java.util.List;

public class MinCostConnect {//leetcode 1584
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<int[]>[] graph=buildGraph(n,points);
        return new Prim(graph).weightSum();
    }

    private List<int[]>[] buildGraph(int n, int[][] points) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
// ⽣成所有边及权重
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int weight = Math.abs(xi - xj) + Math.abs(yi - yj);
// ⽤ points 中的索引表示坐标点
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }
        return graph;
    }
}
