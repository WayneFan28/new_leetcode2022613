package BackTracking.IslandProblem;

import org.junit.Test;

public class MaxAreaOf_Islands {//leetcode 695
    /**
     You are given an m x n binary matrix grid.
     An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
     You may assume all four edges of the grid are surrounded by water.
     */
    int num = 0, temp = 0, maxArea = 0;
    public int maxAreaOf_Island(int[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0;j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    dfs(grid, i, j);
                    maxArea = Math.max(temp, maxArea);
                    num++;
                    temp=0;
                }
            }
        }
        return maxArea;
    }

    public void dfs(int[][] grid, int r, int c){
        if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)){
            return;
        }
        if (grid[r][c] != 1){
            return;
        }
        temp++;//Record the current island area
        grid[r][c]='0';
        int[][] direc ={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : direc){
            dfs(grid, r+d[0], c+d[1]);
        }
    }

    @Test
    public void test1(){
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,1,1},
                {0,1,0,0,1,1,0,0,1,1,1,0,1},
                {0,0,0,0,0,0,0,0,0,0,1,1,1},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxAreaOf_Islands mi = new MaxAreaOf_Islands();
        int i = mi.maxAreaOf_Island(grid);
        System.out.println(i);
    }

}
