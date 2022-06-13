package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        part(s,0,res,new ArrayList<String>());
        return res;
     }

    private void part(String s, int i, List<List<String>> res, ArrayList<String> cur) {

    }
}
