package Array;

import org.junit.Test;

import java.util.Arrays;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {//out timelimit
        int max = Integer.MIN_VALUE;
        int[] win = new int[k];
        int[] res = new int[nums.length - k + 1];
        int start = 0;
        int end = k - 1;
        int j = 0;
        while(end < nums.length){
            for(int i = start; i <= end; i++){
                max = Math.max(nums[i], max);
            }
            res[j] = max;
            max = Integer.MIN_VALUE;
            start++;
            end++;
            j++;
        }

        return res;
    }

//    public int[] maxSlidingWindow(int[] nums, int k){
//
//    }
    @Test
    public void test(){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] test = {1,3,-1,-3,5,3,6,7};
        int[] ints = slidingWindowMaximum.maxSlidingWindow(test, 3);
        System.out.println(Arrays.toString(ints));
    }
}
