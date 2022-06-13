package DynamicProgram;

import org.junit.Test;

public class MaxProfit {
    public int maxProfit0(int[] prices) {//leetcode 121
        int n=prices.length;
        int temp, max=0;
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                temp = prices[j] - prices[i];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {//leetcode 121
        int n=prices.length;
        if (n==0||n==1){
        return 0;
    }
    int [][] dp=new int[n][2];
        for (int i=0;i<n;i++){
        if (i==0){
            dp[i][0]=0;
            dp[i][1]=-prices[i];
            continue;
        }
        dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
    }
        return dp[n-1][0];
}

    public int maxProfit1(int[] prices) {//leetcode 122
        int n=prices.length;
        if (n==0||n==1){
            return 0;
        }
        int [][] dp=new int[n][2];
        for (int i=0;i<n;i++){
            if (i==0){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    public int maxProfitCooldown(int[] prices){
        int n=prices.length;
        if (n==0||n==1){
            return 0;
        }
        int [][] dp=new int[n][2];
        for (int i=0;i<n;i++){
            if (i==0){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
                continue;
            }
            if (i==1){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);;
                dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }

@Test
    public void test(){
    MaxProfit maxProfit = new MaxProfit();
    int [] nums = {7,1,5,3,6,4};
    int i = maxProfit.maxProfit(nums);
    System.out.println(i);
}
}
