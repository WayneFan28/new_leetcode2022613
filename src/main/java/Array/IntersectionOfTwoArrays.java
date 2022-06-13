package Array;

import java.util.HashSet;

public class IntersectionOfTwoArrays {//leetcode 349
    /**
     Given two integer arrays nums1 and nums2,return an array of their intersection.
     Each element in the result must be unique and you may return the result in any order.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, index = 0;
        HashSet<Integer> temp = new HashSet<>();
        HashSet<Integer> restemp = new HashSet<>();
        for (int i = 0; i < m; i++){
            temp.add(nums1[i]);
        }
        for (int j = 0; j < n; j++){
            if (temp.contains(nums2[j])){
                restemp.add(nums2[j]);
            }
        }
        int[] res = new int[restemp.size()];
        for (int i : restemp){
            res[index++] = i;
        }
        return res;
    }
}
