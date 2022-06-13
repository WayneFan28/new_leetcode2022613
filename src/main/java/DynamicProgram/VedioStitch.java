package DynamicProgram;

import java.util.Arrays;

public class VedioStitch {
    public int videoStitching(int[][] clips, int time) {
        if (time == 0) return 0;
        Arrays.sort(clips, (a, b) ->{
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int res = 0, cur = 0, next = 0;
        return 0;
    }
}
