package BackTracking.IslandProblem;

import org.junit.Test;

public class SurroundedRegions {
    /**
     * Given an m x n matrix board containing 'X' and 'O',
     * capture all regions that are 4-directionally surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     */

    public void solveSurroundRegion(char[][] grid){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (i == 0 || j == 0 || i == grid.length -1 || j == grid[0].length -1 ){
                    if (grid[i][j] == 'O'){
                        dfsSurroundedRegion(grid, i, j);
                    }
                }
            }
        }
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
                if (grid[i][j] == 'Y'){
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private void dfsSurroundedRegion(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }
        if (grid[r][c] == 'X' || grid[r][c] == 'Y'){
            return;
        }
        grid[r][c] = 'Y';
        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] d : direc){
            dfsSurroundedRegion(grid, r + d[0], c + d[1]);
        }
    }

    @Test
    public void test(){
        SurroundedRegions sr = new SurroundedRegions();
        char[][] grid = {{'O','O'},{'O','O'}};
        sr.solveSurroundRegion(grid);
    }
}
