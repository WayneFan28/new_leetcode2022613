package String;

import org.junit.Test;

public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();int m=needle.length();
        for (int i=0;i+m<=n;i++){
            boolean flag=true;
            for (int j=0;j<m;j++){
                if (haystack.charAt(i+j)!=needle.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }



    @Test
    public void test(){
        Implement_strStr im = new Implement_strStr();
        String str = "mississippi";String tar = "issip";
        int i = im.strStr(str, tar);
        System.out.println(i);
    }
}
