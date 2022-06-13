package BFS_Search;

import java.util.*;

public class OpenTheLock {//leetcode 752
    int step = 0;
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(String s : deadends){
            deads.add(s);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++){
                String cur = queue.poll();
                if (deads.contains(cur)){
                    continue;
                }
                if (cur.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++){
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String s, int i){//switch s[j] up once
        char[] ch = s.toCharArray();
        if (ch[i] == '9'){
            ch[i] = '0';
        }else{
            ch[i] += 1;
        }
        return new String(ch);
    }

    public String minusOne(String s, int i){//switch s[i] down once
        char[] ch = s.toCharArray();
        if (ch[i] == '0'){
            ch[i] = '9';
        }else{
            ch[i] -= 1;
        }
        return new String(ch);
    }

    public void BFS(String target){
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while (!q.isEmpty()){
            int sz = q.size();
            //Spread all nodes in the current queue around
            for (int i = 0; i < sz; i++){
                String cur = q.poll();
                System.out.println(cur);
                for (int j = 0; j < 4; j++){
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    q.offer(up);
                    q.offer(down);
                }
            }
            step++;
        }
        return;
    }

}
