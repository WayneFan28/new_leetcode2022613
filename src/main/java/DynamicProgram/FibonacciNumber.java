package DynamicProgram;

import org.junit.Test;

public class FibonacciNumber {
    public int fibonacci(int N){
        int[] memo = new int[N+1];
        return helperPlus(memo,N);
    }

    public int helper(int[] memo, int n){
        if (n==0||n==1)return n;
        if (memo[n]!=0)return memo[n];
        memo[n]=helper(memo,n-1)+helper(memo,n-2);
        return memo[n];
    }

    public int helperPlus(int[] memo,int n){
        if (n==0)return 0;
        int[] dp = new int[n+1];
        dp[0]=0;dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int helperMax(int n){
         if (n==0||n==1)return n;
         int prev=0,curv=1;
         for (int i=2;i<=n;i++){
             int sum=prev+curv;
             prev=curv;curv=sum;
         }
         return curv;
    }

    @Test
    public void t(){
        System.out.println(fibonacci(38));
        System.out.println(helperMax(39));
    }
}

