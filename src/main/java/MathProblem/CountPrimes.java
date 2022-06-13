package MathProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CountPrimes {
    public boolean isPrime(int num){//Time limit exceeded
        if (num==1){return false;}
        int temp = (int) Math.sqrt(num);
        for (int i=2;i<=temp;i++){
            if (num%i==0){
                return false;
            }
        }return true;
    }

    public boolean isEvenNumber(int num){
        if (num%2==0&&num>2){
            return true;
        }return false;
    }

    public boolean isNumber(int num){
        if (num%3==0||num%7==0||num%9==0){
            return true;
        }return false;
    }

    public int countPrimes(int n){//Time limit exceeded
        if (n==0||n==1||n==2){
            return 0;
        }
        int count =0;
        for (int c=2;c<n;c++){
            if (isNumber(c)){continue;}
            if (isEvenNumber(c)){continue;}
            if (isPrime(c)){ count++;}
        }
        return count;
    }

    public ArrayList showPrimes(int num){
        ArrayList primelist = new ArrayList();
        for (int i=1;i<=num;i++){
            if (isPrime(i)){primelist.add(i);}
        }
        return primelist;
    }

    @Test
    public void test1(){
        long startTime =System.currentTimeMillis();
        //ArrayList primes = showPrimes(65538);
        //System.out.println(Arrays.toString(new ArrayList[]{primes}));
        System.out.println(countPrimes(10000000));
        long endTime=System.currentTimeMillis();
        System.out.println("Time consume"+(endTime-startTime)+"ms");
    }
}
