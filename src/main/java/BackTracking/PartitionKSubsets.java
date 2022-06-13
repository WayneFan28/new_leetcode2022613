package BackTracking;

import org.junit.Test;

public class PartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {//leetcode 698
        if (k > nums.length) return false;
        int sum = 0;
        for (int s : nums){
            sum += s;//The sum must divised by k
        }
        if (sum % k != 0) return false;
        int tar = sum / k;
        int[] bucket = new int[k];
        boolean[] used =  new boolean[nums.length];
        return backtrack(nums, k, tar, 0, 0, used);
    }

    private boolean backtrack(int[] nums, int k, int tar, int start, int bucket, boolean[] used) {
        if (k == 0) return true;
        if (bucket == tar){
            return backtrack(nums, k - 1, tar, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            if (nums[i] + bucket > tar){
                continue;
            }
            used[i] = true;
            bucket += nums[i];
            if (backtrack(nums, k, tar, i + 1, bucket, used)){
                return true;
            }
            used[i] = false;
            bucket -= nums[i];
        }
        return false;
    }
    @Test
    public void test(){
        PartitionKSubsets pp = new PartitionKSubsets();
        int[] nums = {1,1,1,2,2,2,3,3,3};int k =1;
        System.out.println(pp.canPartitionKSubsets(nums,k));
    }
}
