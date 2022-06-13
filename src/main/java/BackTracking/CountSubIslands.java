package BackTracking;

public class CountSubIslands {//leetcode 1095
    int num=0;
    boolean subisland = true;//判断当前岛屿是否为子岛屿
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i=0;i<grid2.length;i++){
            for (int j=0;j<grid2[0].length;j++){
                if (grid2[i][j]==1){
                    dfs(grid2,i,j,grid1);
                    if (subisland){
                        num++;
                    }
                    subisland = true;
                }
            }
        }
        return num;
    }
    public void dfs(int[][] grid, int r, int c, int[][] fathergrid){
        if (r<0||c<0||r>=grid.length||c>=grid[0].length){
            return;
        }
        if (grid[r][c]!=1){
            return;
        }
        if (fathergrid[r][c]!=1){
            subisland = false;
            return;
        }
        grid[r][c]=0;
        int[][] direc ={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d : direc){
            dfs(grid, r+d[0], c+d[1], fathergrid);
        }
    }
}
