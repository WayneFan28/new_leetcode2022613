package BackTracking.IslandProblem;

import org.junit.Test;

public class NumberOf_ClosedIslands {//leetcode 1254
    int num = 0;int close_num = 0;boolean atboard = false;
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0){
                    dfs(grid, i, j);
                    num++;
                    if (!atboard){
                        close_num++;
                    }
                    atboard = false;
                }
            }
        }
        return close_num;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if (grid[i][j] != 0){
            return;
        }
        if (grid[i][j]==0&&
                (i==grid.length-1||j==grid[0].length-1||i==0||j==0)){
            atboard = true;
        }
        grid[i][j] = 1;
        int[][] direc = {{0,1},{1,0},{-1,0},{0,-1}};
        for (int[] d : direc){
            dfs(grid, i + d[0], j + d[1]);
        }
    }

    @Test
    public void test(){
        NumberOf_ClosedIslands nn = new NumberOf_ClosedIslands();
        int[][] gird  = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}};
        int i = nn.closedIsland(gird);
        System.out.println(i);
    }
}
