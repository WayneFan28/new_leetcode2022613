package UnionFind;

import java.util.concurrent.ConcurrentHashMap;

public class UF_eq {

    int[] parent;
    ConcurrentHashMap<Integer, Integer> h = new ConcurrentHashMap<>();

    public UF_eq(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty){
            return;
        }else {
            parent[rootx] = rooty;
        }
    }

    private int find(int x){
        while (parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int x, int y) {
        if (find(x) == find(y)){
            return true;
        }else {
            return false;
        }
    }
}
