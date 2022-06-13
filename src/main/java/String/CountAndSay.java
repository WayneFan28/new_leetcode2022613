package String;

import org.junit.Test;

public class CountAndSay {
    public String countAndSay(int n){
        if (n==1)return "1";
        else {
            String str = countAndSay(n-1);
            StringBuilder ss = new StringBuilder();
            int i=0,j=1,len=str.length();
            while (j<len){
                if (str.charAt(i)!=str.charAt(j)){
                    ss.append(j-i).append(str.charAt(i));
                    i=j;
                }
                j++;
            }
            ss.append(j-i).append(str.charAt(i));
            return ss.toString();
        }
    }
    @Test
    public void test(){
        CountAndSay countAndSay = new CountAndSay();
        String s = countAndSay.countAndSay(6);
        System.out.println(s);
    }
}
