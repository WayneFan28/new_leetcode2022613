package String;


import org.junit.Test;

import java.util.Stack;

public class ReverseString {
    /**
     Write a function that reverses a string. The input string is given as an array of characters s.
     You must do this by modifying the input array in-place with O(1) extra memory.
     */
    public void reverseString(char[] s){
        int left = 0; char temp = 0;
        int right = s.length-1;
        while (left < right){
            temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
    public int reverseInteger(int x){
        int a = Integer.parseInt(reverse(Math.abs(x)));
        return x<0? -a:a;
    }

    public String reverse(int x){
        String xstr = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<xstr.length();i++){
            sb.append(xstr.charAt(i));
        }
        return sb.reverse().toString();
    }

    /**
     *Given a string s and an integer k, reverse the first k characters for
     * every 2k characters counting from the start of the string.
     * If there are fewer than k characters left, reverse all of them.
     * If there are less than 2k but greater than or equal to k characters,
     * then reverse the first k characters and leave the other as original.
     * @param s
     * @param k
     * @return String
     */
    public String reverseStr(String s, int k) {//leetcode 541
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i = i + 2 * k){
            int r = i + k - 1;
            revers(cs, i, Math.min(r, n - 1));
        }
        return String.valueOf(cs);
    }

    private void revers(char[] cs, int l, int r) {
        while (l < r){
            char temp = cs[l];
            cs[l] = cs[r];
            cs[r] = temp;
            l++; r--;
        }
    }

    @Test
    public void test(){
        ReverseString rs = new ReverseString();
//        int i = rs.reverseInteger(-17888);
//        System.out.println(i);
//        System.out.println(Math.pow(2,16));
        String res = rs.reverseStr("qwertyuiop", 3);
        System.out.println(res);

    }
}
