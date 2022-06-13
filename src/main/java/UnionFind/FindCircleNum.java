package UnionFind;

public class FindCircleNum {

    /**
     There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
     and city b is connected directly with city c, then city a is connected indirectly with city c.
     A province is a group of directly or indirectly connected cities and no other cities outside of the group.
     You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
     connected, and isConnected[i][j] = 0 otherwise.
     Return the total number of provinces.
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;//city numbers
        UF uf = new UF(n);
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}
