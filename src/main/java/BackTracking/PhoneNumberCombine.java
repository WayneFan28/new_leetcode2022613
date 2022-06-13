package BackTracking;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombine {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> phone = new HashMap<>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrackPhone(res, phone, digits, 0, new StringBuffer());
        return res;
    }

    private void backtrackPhone(List<String> res, Map<Character, String> phone, String digits, int i, StringBuffer sb) {
        if (i == digits.length()) {
            res.add(sb.toString());
        } else {
            char digit = digits.charAt(i);
            String letters = phone.get(digit);
            for (int j = 0; j < letters.length(); j++){
                sb.append(letters.charAt(j));
                backtrackPhone(res, phone, digits, i + 1, sb);
                sb.deleteCharAt(i);
            }
        }
    }
    @Test
    public void test(){
        PhoneNumberCombine pp = new PhoneNumberCombine();
        List<String> strings = pp.letterCombinations("2358");
        System.out.println(strings);
    }
}