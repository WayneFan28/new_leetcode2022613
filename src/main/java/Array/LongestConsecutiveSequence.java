package Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {//Time limit exceed
        int res = 0, n = nums.length, temp = 1;
        if (n == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        for (int i = 0; i < n; i++){
            int cur = nums[i];
            while (set.contains(--cur)){
                temp++;
            }
            res = Math.max(temp, res);
            temp = 1;
        }
        return res;
    }
    @Test
    public void test(){
        LongestConsecutiveSequence ll = new LongestConsecutiveSequence();
        int[] nums = {10,4,20,1,3,2};
        int[] nums1 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums2 ={1,2,0,1};
        int[] nums3 = {0};
        System.out.println(ll.longestConsecutive(nums1));
    }
}
