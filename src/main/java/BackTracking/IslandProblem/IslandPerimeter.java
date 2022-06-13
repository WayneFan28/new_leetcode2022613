package BackTracking.IslandProblem;

public class IslandPerimeter {//leetcode 463
    /**
     You are given row x col grid representing a map
     where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
     Grid cells are connected horizontally/vertically (not diagonally).
     The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
     The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
     One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
     Determine the perimeter of the island.
     */
    int islandPerimeter = 0;
    int nums = 0;
    int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfsPerimeter(grid, i, j);
                }
            }
        }
        return islandPerimeter;
    }

    private void dfsPerimeter(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ){
            islandPerimeter++;
            return;
        }
        if (grid[r][c] == 0){
            islandPerimeter++;
            return;
        }
        if (grid[r][c] == -1){
            return;
        }//Prevent double counting of perimeters
        grid[r][c] = -1;
        for (int[] d : direc){
            dfsPerimeter(grid, r + d[0], c + d[1]);
        }
    }
}
