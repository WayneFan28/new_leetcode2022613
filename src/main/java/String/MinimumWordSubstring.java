package String;

import org.junit.Test;

import java.util.HashMap;

public class MinimumWordSubstring {//leetcode76

    /**
     Given two strings s and t of lengths m and n respectively,return the
     minimum window substring of s such that every character in t
     (including duplicates) is included in the window. If there is no such
     substring, return the empty string "".
     */
    public String minWindow(String s, String t) {
        int left = 0, right = 0, valid = 0, start = 0;
        int len = Integer.MAX_VALUE;
        //Number of occurrences of characters in T
        HashMap<Character, Integer> need = new HashMap<>();
        //The number of occurrences of the corresponding character in the window.
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (windows.get(c).equals(need.get(c))) {
                        valid++;
                    }
                    while (valid == need.size() && left < s.length()) {
                        if (right - left < len && right - left > t.length()) {
                            start = left;
                            len = right - left;
                        }
                        char d = s.charAt(left);
                        left++;
                        if (need.containsKey(d)) {
                            if (windows.get(d).equals(need.get(d))) {
                                valid--;
                                windows.put(d, windows.getOrDefault(d, 0) - 1);
                            }
                        }
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    @Test
    public void test(){
        MinimumWordSubstring mm = new MinimumWordSubstring();
        String s = "ADOBECODEBANC";String t = "ABC";
        String s1 = mm.minWindow(s, t);
        System.out.println(s1);
    }
}
