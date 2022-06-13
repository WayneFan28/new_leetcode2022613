package BackTracking.IslandProblem;

import org.junit.Test;

public class NumberOf_Islands {
    int num = 0;
    public int numIslands(char[][] grid) {//leetcode 695,200
        int num = 0;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }
    public void dfs(char[][] grid, int r, int c){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }
        if (grid[r][c] != '1'){
            return;
        }
        grid[r][c] = '0';
        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] d : direc){
            dfs(grid, r + d[0], c + d[1]);
        }
    }
}
