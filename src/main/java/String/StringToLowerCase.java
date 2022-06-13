package String;

import java.util.Scanner;

public class StringToLowerCase {
    public void change() {
        Scanner scan = new Scanner(System.in);
        System.out.print("输入大写字母:");
        char ch = scan.next().charAt(0);
        while (ch <'A'|| ch > 'Z')
        { System.out.print("输入错误,请重新输入：");
            ch =scan.next().charAt(0);
        }
        ch = (char) (ch + 32);//根据ASCII码，大写字母变为小写字母只需要+32即可
        System.out.print("小写字母:" + ch);
    }
}
