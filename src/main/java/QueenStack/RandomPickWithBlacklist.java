package QueenStack;

import java.util.HashSet;
import java.util.Random;

public class RandomPickWithBlacklist {

    public int n;
    public int[] blacklist;
    Random random;
    HashSet<Integer> setList;

    public RandomPickWithBlacklist(int n, int[] blacklist) {
        this.n = n;
        this.blacklist = blacklist;
        this.random = new Random();
        this.setList = new HashSet<>();
        for(int i = 0; i < n; i++){
            setList.add(i);
        }
        for(int i : blacklist){
            setList.remove(i);
        }
    }

    public int pick() {
        return 0;
    }

}
