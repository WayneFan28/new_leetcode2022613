package QueenStack;

import org.junit.Test;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if ("+-*/".contains(token)){
                Integer a = stack.pop();
                Integer b = stack.pop();
                switch (token){
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

@Test
    public void test(){
    EvaluateReversePolishNotation ee = new EvaluateReversePolishNotation();
    String[] tokens = {"2","1","+","3","*"};
    int i = ee.evalRPN(tokens);
    System.out.println(i);
}

}
