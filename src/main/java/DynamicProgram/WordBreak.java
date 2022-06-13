package DynamicProgram;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {//leetcode139
    HashMap<String, Boolean> memohash = new HashMap<>();
    HashSet<String> memo = new HashSet<>();
    boolean result = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, wordDict);
    }

    private boolean dp(String s, List<String> wordDict) {
        if (s.equals("")) return true;
        if (memo.contains(s)) return false;
        for (int i = 0; i < s.length(); i++){
            if (wordDict.contains(s.substring(0, i + 1))){//返回0，i索引字符串
                result = result || dp(s.substring(i + 1), wordDict);
                if(!result){
                    memo.add(s.substring(i + 1));
                }
            }
        }
        return result;
    }

    @Test
    public void test(){
        WordBreak wb = new WordBreak();
        String s = "leetcodeleet";
        String s1 = "catsandogcat";
        List<String> ss = new LinkedList<>();
        ss.add("leet");ss.add("code");
        String[] strs = {"cats", "dog", "sand", "and", "cat", "an"};
        for (String str : strs){
            ss.add(str);
        }
        System.out.println(wb.wordBreak(s1, ss));
    }
}
