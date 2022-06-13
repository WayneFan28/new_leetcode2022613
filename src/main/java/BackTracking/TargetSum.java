package BackTracking;

import org.junit.Test;

public class TargetSum {//leetcode 494
    int res =0;
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        bactrack(nums, 0, target);
        return res;
    }

    private void bactrack(int[] nums, int i, int target) {
        if (i == nums.length){
            if (target == 0){
                res++;
            }
            return;
        }
        //choose plus nums[i]
        target -= nums[i];
        bactrack(nums, i + 1, target);
        target += nums[i];
        //choose minus nums[i]
        target += nums[i];
        bactrack(nums, i + 1, target);
        target -= nums[i];
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TargetSum tt = new TargetSum();
        int targetSumWays = tt.findTargetSumWays(nums, 5);
        System.out.println(targetSumWays);
    }
}
