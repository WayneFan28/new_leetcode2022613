package Array;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures){//leetcode739
        int length=temperatures.length;
        int[] result=new int[length];
        for (int i=0;i<length;i++){
            int cur=temperatures[i];
            if (cur>30&&cur<100){
                for (int j=i+1;j<length;j++){
                    if (temperatures[j]>cur){
                        result[i]=j-i;
                        break;
                    }
                }
            }
        }
        return result;
    }
    public int[] dailyTemp2(int[] T){
        int length=T.length;
        int[] result = new int[length];
        for (int i=length-2;i>=0;i--){
            for (int j=i+1;i<length;j+=result[j]){
                if (T[j]>T[i]){
                    result[i]=j-i;
                    break;
                }else if (result[j]==0){
                    result[i]=0;
                    break;
                }
            }
        }
        return result;
    }
}
