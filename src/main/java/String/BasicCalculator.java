package String;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int num = 0, res = 0, stktop = 0;
        char sign = '+';
        s = s.replaceAll(" ", "");//去除所有空格
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if ('0' <= c && c <= '9'){
                num = 10 * num + (c - '0');
            }
            if (!('0' <= c && c <= '9') || i == s.length() - 1){
                switch (sign){
                    case ('+'):
                        stk.push(num);break;
                    case ('-'):
                        stk.push(-num);break;
                    case '*':
                        stktop = stk.peek();
                        stk.pop();
                        stk.push(stktop * num);
                        break;
                    case '/':
                        stktop = stk.peek();
                        stk.pop();
                        stk.push(stktop / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        while (!stk.empty()){
            res += stk.peek();
            stk.pop();
        }
        return res;
    }

    @Test
    public void test(){
        BasicCalculator bb = new BasicCalculator();
        String s = " 3/2 ";
        int calculate = bb.calculate(s);
        System.out.println(calculate);
        System.out.println(s.replaceAll(" ",""));
    }
}
