package String;

import org.junit.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {//leetcode 14
        String result ="";int cutmax=666;
        for (int k=0;k<strs.length;k++){
            cutmax=Math.min(cutmax,strs[k].length());
        }
        for (int cut=1;cut<=cutmax;cut++){
            for (int i=1;i<strs.length;i++){
                if (!(strs[i].substring(0,cut).equals(strs[0].substring(0,cut)))){
                    if (cut==1){
                        return result;
                    }else return strs[0].substring(0,cut-1);
                }
            }
            result = strs[0].substring(0,cut);
        }
        return result;
    }
    @Test
    public void test(){
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        String[] strs1 = {"cir","car"};
        String[] strs3 = {"ab","a"};
        String s = longestCommonPrefix.longestCommonPrefix(strs3);
        System.out.println(s);
    }
}

