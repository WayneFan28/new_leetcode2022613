package Array;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m-1, left = 0, right = n - 1;
        while (res.size() < m * n){
            if (up <= down){
                for (int j = left; j <= right; j++){
                    res.add(matrix[up][j]);
                }
                up++;
            }
            if (left <= right){
                for (int i = up; i <= down; i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if (up <= down){
                for (int j = right; j >= left; j--){
                    res.add(matrix[down][j]);
                }
                down--;
            }
            if (left <= right){
                for (int i = down; i >= up; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix ss = new SpiralMatrix();
        List<Integer> ii = ss.spiralOrder(m);
        System.out.println(ii);
    }
}
