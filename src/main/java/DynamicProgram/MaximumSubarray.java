package DynamicProgram;

public class MaximumSubarray {//leetcode 300
    public int maxSubArray(int[] nums){
        int res = nums[0];
        int temp=res;
        for (int i=1;i<nums.length;i++){
            temp=Math.max(temp+nums[i],nums[i]);
            if (res<temp){
                res=temp;
            }
        }return res;
    }
}
