package DynamicProgram;

import org.junit.Test;

public class PartitionEqualSubsetSum {//lt416
    public boolean canPart(int[] nums){
        int n=nums.length;
        if (n==1)return false;
        int sumofnums=0,maxofnums=0;
        for (int i:nums){
            maxofnums=Math.max(i,maxofnums);
            sumofnums+=i;
        }
        if (sumofnums%2!=0)return false;
        boolean[][] dp = new boolean[n][sumofnums];
        for (int i=0;i<n;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < sumofnums; j++) {
                if (j < nums[i]) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n-1][sumofnums/2];
    }
    @Test
    public void test(){
        PartitionEqualSubsetSum pp = new PartitionEqualSubsetSum();
        int[] nums = {1,5,11,5,2,3};
        boolean b = pp.canPart(nums);
        System.out.println(b);
    }
}
