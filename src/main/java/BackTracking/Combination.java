package BackTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Combination {//leetcode 77
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        if (k == track.size()){
            res.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i=start;i<=n;i++){
            track.addLast(i);
            backtrack(i+1,n,k);
            track.removeLast();
        }
    }

    @Test
    public void test(){
        Combination combination = new Combination();
        List<List<Integer>> combine = combination.combine(5, 3);
        System.out.println(combine);
    }
}
