package Graph;

import UnionFind.UF;

import java.util.Arrays;

public class CityMinimumCost {//leetcode 1135
    public int minimumCost(int n, int[][] connections){
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int mst = 0;
        for (int[] edge : connections){
            int u = edge[0], v = edge[1], weight = edge[2];
            if (uf.connected(u, v)){
                continue;
            }
            mst += weight;
            uf.union(u, v);
        }
        return uf.getCount() == 2? mst : -1;
    }
}
