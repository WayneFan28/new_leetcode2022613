package Array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 3){
            List<List<Integer>> wrong = new ArrayList<>();
            return wrong;
        }
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0;i < n; i++){
            int l = i + 1;
            int r = n - 1;
            while (l < r){
                if (nums[i] + nums[l] + nums[r] == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }else if(nums[i] + nums[l] +nums[r] < 0){
                    l++;
                }else if(nums[i] + nums[l] +nums[r] > 0){
                    r--;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(res);
        return result;
    }
}
