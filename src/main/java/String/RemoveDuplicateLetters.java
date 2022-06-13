package String;


import org.junit.Test;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {//leetcode 316
        Stack<Character> stk = new Stack<>();
        boolean[] inStack = new boolean[256];
        for (char c:s.toCharArray()){
            if (inStack[c]){
                continue;
            }
            stk.push(c);
            inStack[c]=true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stk.isEmpty()){
            stringBuilder.append(stk.pop());
        }
        return stringBuilder.reverse().toString();
    }

    @Test
    public void test(){
        RemoveDuplicateLetters rm = new RemoveDuplicateLetters();
        String s = "babc";
        String s1 = rm.removeDuplicateLetters(s);
        System.out.println(s1);
    }
}
