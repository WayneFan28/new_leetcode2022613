package BackTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Permutations {//46
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums){
        boolean[] used = new boolean[nums.length];//已经存在 track 中的元素，不能重复选择
        backtrack(nums, used);
        return res;
    }
    public void backtrack(int[] nums, boolean[] used){
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (used[i]){
                continue;
            }
            track.add(nums[i]);
            used[i]=true;
            backtrack(nums, used);
            track.removeLast();
            used[i]=false;
        }
    }
    @Test
    public void test(){
        Permutations pm = new Permutations();
        int[] nums={2,8,9};
        System.out.println(pm.permute(nums));
    }
}
