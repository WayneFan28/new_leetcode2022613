package String;

import org.junit.Test;

import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int res = 0;
        boolean hasodd=false;
        HashMap<Character, Integer> sb = new HashMap<>();
        for (int i=0;i<s.length();i++){
            sb.put(s.charAt(i),sb.getOrDefault(s.charAt(i),0)+1);
        }
        for (Character key:sb.keySet()){
            if (sb.get(key)%2==0){
                res+=sb.get(key);
            }
            if (sb.get(key)%2==1){
                hasodd=true;
                res+=(sb.get(key)-1);
            }
        }
        if (hasodd)res++;
        return res;
    }

    @Test
    public void test(){
        LongestPalindrome ll = new LongestPalindrome();
        String s = "abccccdd";
        String s1 = "abbbb";

        int i = ll.longestPalindrome(s1);
        System.out.println(i);
    }
}
