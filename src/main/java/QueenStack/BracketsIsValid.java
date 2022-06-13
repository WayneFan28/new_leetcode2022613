package QueenStack;

import java.util.Deque;
import java.util.LinkedList;

public class BracketsIsValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (char c:s.toCharArray()){
            if (c=='(')stack.push(')');
            else if (c=='{')stack.push('}');
            else if (c=='[')stack.push(']');
            else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
