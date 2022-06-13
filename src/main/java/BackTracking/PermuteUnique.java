package BackTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {//leetcode 47
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,track,used,res);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used, List<List<Integer>> res) {
        if (track.size()==nums.length){
            if(!res.contains(track)) {
                res.add(new LinkedList<>(track));
            }
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i]){
                continue;
            }
            track.add(nums[i]);
            used[i]=true;
            backtrack(nums,track,used,res);
            track.removeLast();
            used[i]=false;
        }
    }
    @Test
    public void test(){
        PermuteUnique pu = new PermuteUnique();
        int[] nums={2,2,9};
        System.out.println(pu.permuteUnique(nums));
    }
}
