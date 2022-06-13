package MathProblem;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0&&((n&(n-1))==0)?true:false;
    }
    @Test
    public void test(){
        PowerOfTwo power = new PowerOfTwo();
        System.out.println(power.isPowerOfTwo(160));
    }

    public int singleNumber(int[] nums){
        int res = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        for (int key:hs.keySet()){
            if(hs.get(key)==1){
                res = key;
            }
        }
        return res;
    }
    public int singleNumber1(int[] nums){
        int res=0;for (int n:nums)res^=n;return res;
    }
    @Test
    public void test1(){
        PowerOfTwo two = new PowerOfTwo();
        int[] nums = {4,1,2,1,2,3,10,10,4,4};
        int i = two.singleNumber(nums);
        System.out.println(i);
    }

    public int missNumber(int[] nums){
        int n = nums.length,res=0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0;i<n;i++){
            hs.add(nums[i]);
        }
        for (int i=0;i<=n;i++){
            if (!hs.contains(i)){
                res=i;
            }
        }
        return res;
    }
}
