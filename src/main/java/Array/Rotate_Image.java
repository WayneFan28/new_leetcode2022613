package Array;

import org.junit.Test;

import java.util.Arrays;

public class Rotate_Image {
    public int[][] clockwiseRotate(int[][] matrix) {//leetcode48
        int m = matrix.length;
        for (int i = 0;i < m; i++){
            for (int j = i; j < m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] row : matrix){
            reverseRow(row);
        }
        return matrix;
    }

    private void reverseRow(int[] row) {
        int i = 0, j = row.length - 1;
        while (j > i){
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test(){
        Rotate_Image rotate_image = new Rotate_Image();
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] ints = rotate_image.clockwiseRotate(m);
        for (int[] a : ints){
            System.out.println(Arrays.toString(a));
        }
    }

}
