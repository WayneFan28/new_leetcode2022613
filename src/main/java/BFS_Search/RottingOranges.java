package BFS_Search;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {//leetcode 994

    int times = 0;
    int rottenOrange = 0, freshOrange = 0;
    int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//control direction

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //Store the coordinates of the initial rotten orange into the queue
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    //Calculate the initial number of good oranges
                    freshOrange++;
                }else if (grid[i][j] == 2){
                    //Add initial rotten orange coordinates
                    //rottenOrange++;
                    queue.add(new int[]{i, j});
                }
            }
        }
        //Exit when the good oranges are all tainted or the queue is empty
        while (freshOrange > 0 && !queue.isEmpty()){
            times++;//One cycle time plus one
            int sz = queue.size();
            for (int i = 0; i < sz; i++){
                //Rotten oranges pop up in the queue
                int[] orange = queue.poll();
                //Get the coordinates of the current rotten orange
                int r = orange[0], c = orange[1];
                //Traverse the rotten oranges up, down, left and right and the coordinates are not out of bounds
                for (int[] dir : direc){
                    if (r + dir[0] >= 0 && r + dir[0] < m
                            && c + dir[1] >= 0 && c + dir[1] < n &&
                            grid[r + dir[0]][c + dir[1]] == 1){
                            //Contaminated oranges
                            grid[r + dir[0]][c + dir[1]] = 2;
                            freshOrange--;
                            //Add tainted rotten oranges into the queue
                            queue.add(new int[]{r + dir[0], c + dir[1]});
                    }
                }
            }
        }
        return freshOrange > 0 ? -1 : times;
    }
}
