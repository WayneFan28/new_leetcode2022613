package BackTracking.IslandProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    int[][] direc ={{0,1}, {0,-1}, {1,0}, {-1,0}};
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights){
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++){
            dfsPacificAtlantic(i, 0, pacific, heights);
        }
        for (int j = 1; j < n; j++){
            dfsPacificAtlantic(0, j, pacific, heights);
        }
        for (int i = 0; i < m; i++){
            dfsPacificAtlantic(i, n - 1, atlantic, heights);
        }
        for (int j = 0; j < n - 1; j++){
            dfsPacificAtlantic(m - 1, j, atlantic, heights);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }

    private void dfsPacificAtlantic(int r, int c, boolean[][] sea, int[][] heights) {
        if (sea[r][c]){
            return;
        }
        sea[r][c] = true;
        for (int[] dir : direc){
            int newRow = r + dir[0], newCol = c + dir[1];
            if (newRow >=0 && newRow < m && newCol >= 0 && newCol < n){
                if (heights[newRow][newCol] >= heights[r][c]){
                    dfsPacificAtlantic(newRow, newCol, sea, heights);
                }
            }
        }
    }

    @Test
    public void test(){
        PacificAtlanticWaterFlow pf = new PacificAtlanticWaterFlow();
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = pf.pacificAtlantic(heights);
        System.out.println(lists);
    }
}
