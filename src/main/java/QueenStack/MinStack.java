package QueenStack;

import java.util.Stack;

public class MinStack {//leetcode 155

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(Stack<Integer> stack, Stack<Integer> minStack) {
        this.stack = stack;
        this.minStack = minStack;
    }

    public void push(int x){
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop(){
        if (stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
