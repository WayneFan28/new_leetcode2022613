package MathProblem;

import org.junit.Test;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x==0) return true;
        String s = Integer.toString(x);
        char[] schar = s.toCharArray();
        int left = 0;int right = schar.length-1;boolean res=false;
        for (int i=0;i<=schar.length/2;i++){
            if (schar[left]!=schar[right]){
                res = false;break;
            }else {
                res = true;
            }
            left++;right--;
        }
        return res;
    }
    @Test
    public void test(){
        PalindromeNumber pp = new PalindromeNumber();
        boolean palindrome = pp.isPalindrome(5);
        System.out.println(palindrome);
    }
}
