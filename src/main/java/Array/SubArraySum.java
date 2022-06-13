package Array;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {//leeetcode560
        int n=nums.length;
        int[] preSum=new int[n+1];
        int count = 0;
        preSum[0]=0;
        for (int i=0;i<n;i++){
            preSum[i+1]=preSum[i]+nums[i];
        }
        for (int i=1;i<=n;i++)
            for (int j=0;j<i;j++){
                if (preSum[i]-preSum[j]==k){
                    count++;
                }
            }
        return count;
    }
}
