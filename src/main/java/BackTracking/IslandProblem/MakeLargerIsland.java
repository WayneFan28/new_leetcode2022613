package BackTracking.IslandProblem;

import org.junit.Test;

import java.util.*;

public class MakeLargerIsland {//leetcode 827

    HashMap<Integer, Integer> sizeMap = new HashMap<>();//Island index， size
    int[][] direcs = {{1, 0}, {-1, 0}, {0, -1}, {0 ,1}};
    int tempSize = 0;//Calculate island area retain value
    int islandIndex = 2;//index from 2 to n to indicate according island
    int res = 0;
    int bindSize = 0;//Indicates the added island area
    boolean hasNeighborIsland = false;//There are islands around, plus one area
    boolean[] addedNeighborIsland;//Prevents repeated addition of the area of the same island
    int maxIslandSize = 0;//Retain the previous largest island size
    boolean zeroIsland = true;

    public int largestIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++){//Calculate the area of each island
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    zeroIsland = false;
                    dfsCountIslandSize(grid, i, j);
                    maxIslandSize = Math.max(tempSize, 0);
                    sizeMap.put(islandIndex, tempSize);
                    tempSize = 0;
                    islandIndex++;
                    res = maxIslandSize;//to prevent the situation where the entire map is an island

                }
            }
        }
        if (zeroIsland){
            return 1;
        }
        addedNeighborIsland = new boolean[grid.length * grid[0].length];
        Arrays.fill(addedNeighborIsland, false);
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    grid[i][j] = 1;
                    dfsMakeLargerIsland(grid, i, j);
                    res = Math.max(res, bindSize);
                    grid[i][j] = 0;
                    bindSize = 0;
                    Arrays.fill(addedNeighborIsland, false);
                }
            }
        }
        return Math.max(maxIslandSize, res);
    }

    private void dfsMakeLargerIsland(int[][] grid, int r, int c) {
        for (int[] d : direcs){
            if (r + d[0] < 0 || c + d[1] < 0 || r + d[0] >= grid.length || c + d[1] >= grid[0].length){
                continue;
            }
            if (grid[d[0] + r][d[1] + c] > 1){
                hasNeighborIsland = true;
                while (!addedNeighborIsland[grid[d[0] + r][d[1] + c]]){
                    bindSize += sizeMap.get(grid[d[0] + r][d[1] + c]);
                    addedNeighborIsland[grid[d[0] + r][d[1] + c]] = true;
                }
            }
        }
        if (hasNeighborIsland){
            bindSize++;
        }
    }

    private void dfsCountIslandSize(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }
        if (grid[r][c] == 0 || grid[r][c] > 1){
            return;
        }
        tempSize++;
        grid[r][c] = islandIndex;
        for (int[] d : direcs){
            dfsCountIslandSize(grid, r + d[0], c + d[1]);
        }
    }

//    @Test
//    public void test(){
//        int[][] grid = {
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,1,1},
//                {0,1,0,0,1,1,0,0,1,1,1,1,1},
//                {0,0,0,0,0,0,0,0,0,0,1,1,1},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//        int[][] grid1 = {{0,1}, {1, 0}};
//        int[][] grid2 = {{1,1}, {1, 1}};
//        int[][] grid4 = {{1,0}, {0, 0}};
//        int[][] grid3 = {{1,0,0}, {0,1, 1},{0,1,1}};
//        MakeLargerIsland mkl = new MakeLargerIsland();
//        int i = mkl.largestIsland(grid4);
//        System.out.println(i);
//    }
}
