package String;

import org.junit.Test;

import java.util.Arrays;

public class RegularExpressMatch {//leetcode10
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0]=true;
        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j)=='*'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j)=='*'){
                    if (s.charAt(i-1)!=p.charAt(j-2)&&p.charAt(j-1)!='.'){
                        dp[i][j]=dp[i][j-2];
                    }
                    if (s.charAt(i-1)==p.charAt(j-2)&&p.charAt(j-1)!='.'){
                        dp[i][j]=(dp[i][j-1]||dp[i-1][j]);
                    }
                    if ((s.charAt(i-1)!=p.charAt(j-2))&&p.charAt(j-1)=='.'){
                        dp[i][j]=true;
                    }
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String s =" "+"aa",p=" "+"a";
        RegularExpressMatch gr = new RegularExpressMatch();
        boolean match = gr.isMatch(s, p);
        System.out.println(match);
    }
}
