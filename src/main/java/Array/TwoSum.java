package Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     Given an array of integers nums and an integer target,
     return indices of the two numbers such that they add up to target.
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(target == nums[i] + nums[j]){
                    res[0] = i; res[1] = j;
                }
            }
        }
        return res;
    }

    public int[] twoSumHash(int[] nums, int target){
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                map.put(nums[i], i);
            }
            for(int i = 0; i < nums.length; i++){
                int complement = target - nums[i];
                if(map.containsKey(complement) && map.get(complement) != i){
                    return new int[]{i, map.get(complement)};
                }
            }
            return new int[] {-1,1};
        }

    @Test
    public void test(){
        TwoSum twoSum = new TwoSum();
        int[] nums = {3,3};
        int[] sum = twoSum.twoSum(nums, 5);
        int[] sum1 = twoSum.twoSumHash(nums,5);
        System.out.println(Arrays.toString(sum));
        System.out.println(Arrays.toString(sum1));
    }


}
