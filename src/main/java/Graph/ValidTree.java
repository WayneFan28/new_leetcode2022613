package Graph;

import UnionFind.UF;

public class ValidTree {
    public boolean validTree(int n, int[][] edges){
        UF uf = new UF(n);
        for (int[] edge : edges){
            int u = edge[0], v = edge[1];
            if (uf.connected(u, v)){
                return false;
            }
            uf.union(u, v);
        }
        return uf.getCount() == 1;
    }
}
