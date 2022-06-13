package BackTracking.IslandProblem;

import org.junit.Test;

public class NumbersOf_Enclaves {//leetcode 1020
    int temp=0;boolean atBorder=false;int enclave = 0;
    public int numEnclaves(int[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    dfs(grid,i,j);
                    if (!atBorder){
                        enclave+=temp;
                    }
                    atBorder=false;
                    temp=0;
                }
            }
        }
        return enclave;
    }
    public void dfs(int[][] grid, int r, int c){
        if (r<0||c<0||r>=grid.length||c>=grid[0].length){
            return;
        }
        if (grid[r][c]!=1){
            return;
        }
        if (r==0||c==0||r==grid.length-1||c==grid[0].length-1){
            atBorder=true;
        }
        temp++;
        grid[r][c]='0';
        int[][] direc ={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d : direc){
            dfs(grid, r+d[0], c+d[1]);
        }
    }
    @Test
    public void test(){
        NumbersOf_Enclaves nn = new NumbersOf_Enclaves();
        int[][] gird  = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };
        for (int i=0;i<gird.length;i++){
            for (int j=0;j<gird[0].length;j++){
                gird[i][j] = gird[i][j]==1? 0:1;
            }
        }
        int i = nn.numEnclaves(gird);
        System.out.println(i);
    }
}
