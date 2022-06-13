package Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class SetMismatch {
    int[] result = new int[2];
    int[] count = new int[100];
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }
        int[] count=new int[nums.length+1];
        for (int i=0;i<nums.length;i++){
            count[map.get(i)]++;
        }
        for (int i=1;i<count.length;i++){
            if (count[i]==0){
                result[1]=i;
            }
            if (count[i]==2){
                result[0]=i;
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums = {1,2,2,4};
        SetMismatch setMismatch = new SetMismatch();
        int[] errorNums = setMismatch.findErrorNums(nums);
        System.out.println(Arrays.toString(errorNums));
    }
}
