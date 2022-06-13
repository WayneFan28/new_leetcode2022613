package Array;

import java.util.Random;

public class SortArray {//leetcode 912
    /**
     Given an array of integers nums, sort the array in ascending order.
     */
    private static void swap(int[] nums,int i,int j){
        int temp = Integer.MIN_VALUE;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void shuffle(int[] nums){//randomly shuffles the input array
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private static boolean greater(int v, int w){
        if (v > w){
            return true;
        }else{
            return false;
        }
    }

    public int[] quickSort(int[] nums){
        shuffle(nums);
        qsort(nums, 0, nums.length-1);
        return nums;
    }

    private void qsort(int[] nums, int lo, int hi) {
        if (lo >= hi){
            return ;
        }
        int p = partition(nums, lo, hi);
        qsort(nums, lo, p - 1);
        qsort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1, j = hi;
        while (i <= j){
            while (i < hi && nums[i] <= pivot){
                i++;
            }
            while (j > lo && nums[j] > pivot){
                j--;
            }
            if (i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public int[] BubbleSortArray(int[] nums) {//time limit break O(n2)
        for (int i = nums.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (greater(nums[j], nums[j + 1])){
                    swap(nums,j,j+1);
                }
            }
        }
        return nums;
    }


}
