package MathProblem;

public class LemonChange {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]==10||bills[0]==20){
            return false;
        }
        int $5 = 1,$10=0,$20=0;
        for (int i=1;i<bills.length;i++){
            if (bills[i]==5){
                $5++;
            }else if (bills[i]==10){
                if ($5>0) {
                    $10++;
                    $5--;
                }else return false;
            }else if (bills[i]==20){
                if ($5>2&&$10<=0){
                    $5-=3;
                }else if ($5>0&&$10>0){
                    $5--;$10--;
                }else return false;
            }
        }
        if ($5<0){
            return false;
        }
        return true;
}
}
