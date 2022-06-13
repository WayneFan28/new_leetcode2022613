package BackTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SubSets {//leetcode 78
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int i=start;i<nums.length;i++){
            track.addLast(nums[i]);
            backtrack(nums,i+1);
            track.removeLast();
        }
    }

    @Test
    public void test(){
        SubSets subSets = new SubSets();
        int[] nums = {1,2,3};
        List<List<Integer>> list = subSets.subsets(nums);
        System.out.println(list);
    }
}
