package DynamicProgram;

import org.junit.Test;

import java.util.Arrays;

public class CoinChange {//leetcode 322, 518

    public int coinChangeRecur(int[] coins,int amount){//Overtime暴力解决
            if (amount==0)return 0;
            if (amount<0)return -1;
            int res = Integer.MAX_VALUE;
            for (int coin : coins)
            {
                int subProblem = coinChangeRecur(coins,amount - coin);
                if (subProblem == -1) continue;
                res=Math.min(res,subProblem+1);
        }
            return res==Integer.MAX_VALUE? -1 : res;
    }

    int[] memo;//自顶向下解法
    public int coinChangeDp(int[] coins,int amount){
        memo = new int[amount+1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return dp(coins, amount);
    }
    private int dp(int[] coins, int amount) {
        if (amount==0) return 0;
        if (amount<0) return -1;
        if (memo[amount] != Integer.MIN_VALUE) return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            int subProblem = dp(coins,amount-coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem+1);
        }
        memo[amount] = (res == Integer.MAX_VALUE)? -1 : res;
        return memo[amount];
    }

    public int coinchangeUp(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);dp[0]=0;
        for (int i=0;i<dp.length;i++){
            for (int coin:coins){
                if (i-coin<0)continue;
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return (dp[amount]==amount+1)?-1:dp[amount];
    }

    public int change(int amount, int[] coins){//leetcode 518 coinchange2
        int N = coins.length;
        int[][] dp = new int[N+1][amount+1];
        for (int i = 0; i < amount+1; i++){
            dp[0][i] = 0;
        }
        for (int j = 0; j < N+1; j++){
            dp[j][0] = 1;
        }
        for (int i = 1; i < N + 1; i++){
            for (int j = 1; j < amount + 1; j++){
                if (j - coins[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][amount];
    }

    @Test
    public void test(){
        CoinChange coinChange = new CoinChange();
        int[] coins = {1,5,20,50,100,200,500};//{1,5,10,20,50,100}
        int[] coins1 = {1,2,5};
        int i = coinChange.coinChangeDp(coins, 5999);//8994
        int change = coinChange.change(99999, coins);
        //System.out.println(i);
        System.out.println(change);
        System.out.println(coinChange.change(10, coins1));
    }
}
