package BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubsetsWithDup {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
}
