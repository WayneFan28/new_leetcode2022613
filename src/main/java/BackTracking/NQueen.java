package BackTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class NQueen {//51

    int[] array = new int[50];
    public int count = 0;
    List<List<String>> resultQ = new LinkedList<>();
    public int count_N_Queen(int max){//leetcode 50
        array = new int[max];
        set(0, max);//
        return count;
    }

    public List<List<String>> solveNqueens(int max){//leetcode51
        array = new int[max];
        set(0, max);
        return resultQ;
    }

    public void set(int n, int max){//n indicates current line number
        if (n == max){
            //print(max);
            resultQ.add(queenResult(max));
            count++;//Current placement is correct
            return;
        }
        for (int i = 0;i < max; i++){
            array[n] = i;
            if (judge(n)){
                set(n + 1, max);
            }
        }
    }

    private void print(int max) {
        for (int j : array){
            System.out.print(j);//+"\t"
        }
        System.out.println();
        System.out.println("-----");
    }

    private List<String> queenResult(int max){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++){
            sb.append(".");
        }
        String s = sb.toString();
        LinkedList<String> res = new LinkedList<>();
        for (int j : array){
            sb.setCharAt(j, 'Q');
            res.add(sb.toString());
            sb.setCharAt(j, '.');
        }
        return res;
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++){
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;//Number of column is same or on the same slash
            }
        }
        return true;
    }

    @Test
    public void test(){
        NQueen nQueen = new NQueen();
        //int i = nQueen.count_N_Queen(5);
        //System.out.println(i);
        List<List<String>> lists = nQueen.solveNqueens(4);
        System.out.println(lists);
    }
}
