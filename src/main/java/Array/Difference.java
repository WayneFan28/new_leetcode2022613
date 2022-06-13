package Array;

public class Difference {
    public int[] diff;
    public int[] difference(int[] nums){
        if (nums.length==0){return null;}
        int[] diff = new int[nums.length];
        diff[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            diff[i]=nums[i]-nums[i-1];
        }
        return diff;
    }
    public int[] increment(int i,int j,int val,int[] nums){
        nums[i]+=val;
        if (j+1<nums.length){
            nums[j+1]-=val;
        }
        return nums;
    }
    public int[] result(int[] nums){
        int[] res=new int[nums.length];
        res[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            res[i]=res[i-1]+nums[i];
        }
        return res;
    }
}
