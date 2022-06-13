package String;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class MultiplyStrings {//leetcode 43 字符串模拟乘法 有问题
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        //List<Integer> res = new LinkedList<>(m + n);
        HashMap<Integer, Integer> res = new HashMap<>(m + n);
        for (int k = 0; k < m + n; k++){
            res.put(k, 0);
        }
        for (int i = m-1; i >= 0 ; i--){
            for (int j = n - 1; j >= 0; j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res.get(p2);
                res.put(p2, sum % 10);
                res.put(p1, sum / 10);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < res.size(); j++){
            sb.append(Integer.toString(res.get(j)));
        }
        String result = sb.toString();
        return result;
    }
    @Test
    public void test(){
        String s1 = "123", s2 = "456";
        MultiplyStrings ms = new MultiplyStrings();
        String multiply = ms.multiply(s1, s2);
        System.out.println(multiply);
    }
}
