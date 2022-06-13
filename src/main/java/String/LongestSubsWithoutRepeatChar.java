package String;

import org.junit.Test;

import java.util.HashMap;

public class LongestSubsWithoutRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0,res=0;
        HashMap<Character,Integer> window=new HashMap<>();
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            while (window.get(c)>1){
                char d=s.charAt(left);
                left++;
                window.put(d,window.getOrDefault(d,0)-1);
            }
            res=Math.max(res,right-left);
            }
        return res;
    }
    @Test
    public void test(){
        LongestSubsWithoutRepeatChar l = new LongestSubsWithoutRepeatChar();
        String str="abcabcbb";
        String str1="pwwkew";
        int i = l.lengthOfLongestSubstring(str1);
        System.out.println(i);
    }
}

