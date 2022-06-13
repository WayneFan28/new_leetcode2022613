package MathProblem;

import org.junit.Test;

public class ContainMostWater {//leetcode11
    public int maxArea(int[] height){
        int left = 0, right = height.length-1, area = 0;
        while (left<right){
            area = Math.max(area,(right-left)*Math.min(height[left],height[right]));
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return area;
    }
    @Test
    public void test(){
        ContainMostWater co = new ContainMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = co.maxArea(height);
        System.out.println(i);
    }
}
