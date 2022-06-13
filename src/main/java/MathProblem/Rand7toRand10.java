package MathProblem;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class Rand7toRand10 {
    public int[] rand7(int n){
        int[] ints = new int[n];
        Random random = new Random();
        int max=7;int min=1;
        for (int i=0;i<n;i++){
            int ranNumber =random.nextInt(max - min + 1) + min;
            ints[i] = ranNumber;
        }
        return ints;
    }


    public int rand7(){
        Random random = new Random();
        int max=7;int min=1;
        int ranNumber =random.nextInt(max - min + 1) + min;
        return ranNumber;
    }

    public int rand10(){
        // 首先得到一个数
        int num = (rand7() - 1) * 7 + rand7();
        // 只要它还大于10，那就给我不断生成，因为我只要范围在1-10的，最后直接返回就可以了
        while (num > 10){
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;

    }

    @Test
    public void test1(){
        System.out.println(Arrays.toString(rand7(20)));
        System.out.println(rand7());
        System.out.println(rand10());
    }
}
