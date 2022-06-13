package Array;

public class MergeSortArray {
    private static int[] temp;
    public int[] mergeSort(int[] nums){
        temp=new int[nums.length];
        sort(nums,0,nums.length-1);
        return nums;
    }
    private void sort(int[] nums,int lo,int hi){
        if (lo==hi){
            return;
        }
        int mid=lo+(hi-lo)/2;
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    private void merge(int[] nums,int lo,int mid,int hi){
        for (int i=lo;i<=hi;i++){
            temp[i]=nums[i];
        }
        int i=lo,j=mid+1;
        for (int p=lo;p<=hi;p++){
            if (i==mid+1){
                nums[p]=temp[j++];
            }else if (j==hi+1){
                nums[p]=temp[i++];
            }else if (temp[i]>temp[j]){
                nums[p]=temp[j++];
            }else {
                nums[p]=temp[i++];
            }
        }
    }
}
