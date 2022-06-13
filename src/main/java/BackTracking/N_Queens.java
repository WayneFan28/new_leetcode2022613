package BackTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class N_Queens {
    int[] array = new int[50];
    int count = 0;
    List<List<String>> resultQ = new LinkedList<>();

    public List<List<String>> solveNQueens(int max) {
        array = new int[max];
        dp(0, max);
        return resultQ;
    }

    public int countNQueen(int max){
        array = new int[max];
        dp(0, max);
        return count;
    }

    public void dp(int n, int max){
        if(n == max){
            count++;
            resultQ.add(queenResult(max));
            return;
        }
        for(int i = 0; i < max; i++){
            array[n] = i;
            if(judge(n)){
                dp(n + 1, max);
            }
        }
    }

    private List<String> queenResult(int max){
        StringBuilder sb = new StringBuilder();
        Character X = '+';
        for (int i = 0; i < max; i++){
            sb.append(X);
        }
        String s = sb.toString();
        LinkedList<String> res = new LinkedList<>();
        for (int j : array){
            sb.setCharAt(j, 'Q');
            res.add(sb.toString());
            sb.setCharAt(j, X);
        }
        return res;
    }

    private boolean judge(int n){
        for(int i = 0; i < n; i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    public int nQueenPrint(int n){
        N_Queens nn = new N_Queens();
        List<List<String>> lists = nn.solveNQueens(n);
        for (List<String> r : lists){
            for (int i = 0; i < n; i++){
                System.out.println(r.get(i));
            }
            count++;
            System.out.println("---------------");
        }
        System.out.println(count);
        return count;
    }

    @Test
    public void test(){
        for (int i = 3; i <= 12; i++){
            N_Queens n_queens = new N_Queens();
            System.out.println(i + " has -> " + n_queens.countNQueen(i) + " methods ");
        }
    }
}
