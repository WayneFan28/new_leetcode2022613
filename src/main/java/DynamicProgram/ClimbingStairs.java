package DynamicProgram;

import org.junit.Test;

import java.util.HashMap;

public class ClimbingStairs {
    long[] memo;
    public int climbStairs0(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs0(n - 1) + climbStairs0(n - 2);
    }

    public long climbStairs(int n){
        memo = new long[n + 2];
        memo[1] = 1;
        memo[2] = 2;
        return dp(n);
    }

    private long dp(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        ClimbingStairs cl = new ClimbingStairs();
        long i = cl.climbStairs(400);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(i);
    }
}



