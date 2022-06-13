package Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings,int n){
        int[] nums=new int[n];
        Difference df = new Difference();
        int[] diff = df.difference(nums);
        for (int[] booking:bookings){
            int i=booking[0]-1;
            int j=booking[1]-1;
            int val=booking[2];
            df.increment(i,j,val,nums);
        }
        return df.result(nums);
    }
    @Test
    public void test1(){
        int [][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n=5;
        List<Integer> ll = new LinkedList<>();
        Difference df = new Difference();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=0;
        }
        int[] diff = df.difference(nums);
        for (int[] booking:bookings){
            int i=booking[0]-1;
            int j=booking[1]-1;
            int val=booking[2];
            df.increment(i,j,val,diff);
        }
        int[] result = df.result(diff);
        System.out.println(Arrays.toString(result));
    }
}
