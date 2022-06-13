package String;

import org.junit.Test;

import java.util.HashMap;

public class RansomNote {//leetcode 383

    /**
     Given two strings ransomNote and magazine,
     return true if ransomNote can be constructed from magazine and false otherwise.
     Each letter in magazine can only be used once in ransomNote.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] maga = new int[26];//story the number of magazine
        int m = ransomNote.length(), n = magazine.length();
        if (m > n) return false;
        for (int i = 0; i < n; i++){//Store the number of letters in the magazine into an array
            int c = magazine.charAt(i) -'a';
            maga[c]++;
        }
        for (int i = 0; i < m; i++){
            int c = ransomNote.charAt(i) - 'a';
            maga[c]--;
            if (maga[c] < 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String r = "aa", m = "ab";
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct(r,m));
    }
}
