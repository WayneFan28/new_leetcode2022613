package Array;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {//leetcode26
    public int removeDuplicates(int [] nums){
        if(nums.length == 0) return 0;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

}
