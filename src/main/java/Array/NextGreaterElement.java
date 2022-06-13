package Array;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int length=nums.length;
        int[] result=new int[length];
        for (int i=0;i<length-1;i++){
            int cur=nums[i];
            for (int j=0;j<length;j++){
                if (nums[j]>cur){
                    result[i]=nums[j];
                    break;
                }else {
                    result[i]=-1;break;
                }
            }
        }
        for (int k=0;k<length;k++){
            if (nums[k]>nums[length-1]){
                result[length-1]=nums[k];
            }else {
                result[length-1]=-1;
            }
        }
        return result;
    }
}
