package BackTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        add("(",1,0,  n);
        return res;
    }

    private void add(String s, int left, int right,  int n) {
        if (s.length() == 2 * n){
            res.add(s);
            return;
        }
        if (left < n){
            add(s + "(",left+1, right, n);
        }
        if (right < left){
            add(s + ")", left,right+1, n);
        }
    }
    @Test
    public void test(){
        GenerateParenthese ge = new GenerateParenthese();
        List<String> strings = ge.generateParenthesis(13);
        System.out.println(strings);
    }
}
