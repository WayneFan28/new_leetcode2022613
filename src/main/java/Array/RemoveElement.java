package Array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int left=0;
        for (int right=0;right<n;right++){
            if (nums[right]!=val){
                nums[left++]=nums[right];
            }
        }
        return left;
    }
}
