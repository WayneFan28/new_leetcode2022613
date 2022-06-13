package DynamicProgram;

import org.junit.Test;

import java.util.Arrays;

public class LongestIncreaseSub {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,1);
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for (int i=0; i<dp.length; i++){
            res=Math.max(res, dp[i]);
        }
        return res;
    }
    @Test
    public void test(){
        LongestIncreaseSub ll = new LongestIncreaseSub();
        int[] nums={10,9,2,5,3,7,101,18};
        int i = ll.lengthOfLIS(nums);
        System.out.println(i);
    }
}

