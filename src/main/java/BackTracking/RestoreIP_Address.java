package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP_Address {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len=s.length();
        if (len<4||len>12){
            return res;
        }
        dfs(s,res,0,"");
        return res;
    }

    private void dfs(String s, List<String> res, int start,String t) {
        int reslen=s.length()+3;
        if (t.length()==reslen&&start==s.length()){
            res.add(t);
            return;
        }
        if (t.length()==reslen&&start<s.length()){
            return;
        }
    }


}
