package Array;

public class MinSubarrayLen {
    public int minSubArrayLen1(int target, int[] nums) {//leetcode209
        int n=nums.length;
        if (n==0){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int sum=0;
            for (int j=i;j<n;j++){
                sum+=nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
            }
        }
    }
        return ans == Integer.MAX_VALUE ? 0 : ans;
}
    public int minSubArrayLen2(int target,int[] nums){
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    }

