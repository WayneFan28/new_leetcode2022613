package DynamicProgram;

import org.junit.Test;

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= n; i++){
            char a = s.charAt(i - 1), b = s.charAt(i - 2);
            if ('1' <= a && a <= '9'){
                dp[i] += dp[i - 1];
            }
            if((a == '1' || a == '2') && b <= '6'){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        DecodeWays dd = new DecodeWays();
        String s1 = "211";
        System.out.println(dd.numDecodings(s1));
    }
}
