package DynamicProgram;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverLapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {//lt435
        if (intervals.length==0)return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i, int[] j) {
                //negative cross Problem intervals4 = {{-2147483646,-2147483645},{2147483646,2147483647}};
                if (i[1]>j[1])return 1;
                if (i[1]==j[1])return 0;
                return -1;
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for (int[] ints:intervals){
            int start = ints[0];
            if (start>end){
                count++;
                end = ints[1];
            }
        }
        return count;
    }
    @Test
    public void test1(){
        NonOverLapIntervals nn = new NonOverLapIntervals();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals1 = {{10,16},{2,8},{1,6},{7,12}};
        int[][] intervals2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] intervals3 = {{1,2},{3,4},{5,6},{7,8}};
        int[][] intervals4 = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int i = nn.eraseOverlapIntervals(intervals4);
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
