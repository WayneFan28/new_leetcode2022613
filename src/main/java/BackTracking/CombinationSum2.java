package BackTracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {//leetcode 40
    List<List<Integer>>  result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length==0){
            return result;
        }
        Arrays.sort(candidates);
        backtrack(candidates,0,target);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (sum==target){
            result.add(new LinkedList<>(track));
            return;
        }
        if (sum>target){
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
            track.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,i+1,target);
            track.removeLast();
            sum-=candidates[i];
        }
    }
    @Test
    public void test(){
        CombinationSum2 sum = new CombinationSum2();
        int[] nums = {2,3,2,1,2,7};
        List<List<Integer>> lists = sum.combinationSum(nums, 7);
        System.out.println(lists);
    }
}
