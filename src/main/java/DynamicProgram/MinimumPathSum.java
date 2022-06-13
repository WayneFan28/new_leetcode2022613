package DynamicProgram;

import org.junit.Test;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid){//leetcode 64
        int m=grid.length, n=grid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = grid[0][0];
        for (int i=1; i<m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];//第一列值初始化
        }
        for (int i=1; i<n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];//第一行的值初始化
        }
        for (int i=1; i<m; i++){
            for (int j=1 ; j<n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    @Test
    public void test(){
        MinimumPathSum mm = new MinimumPathSum();
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid1={{1,2,3},{4,5,6}};
        int i = mm.minPathSum(grid);
        System.out.println(i);
    }

}
