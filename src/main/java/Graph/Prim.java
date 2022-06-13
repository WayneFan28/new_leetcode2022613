package Graph;

import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    private PriorityQueue<int[]> pq;
    private boolean[] inMST;
    private int weightSum=0;
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph){
        this.graph=graph;
        this.pq=new PriorityQueue<>((a,b)->{
           return a[2]-b[2];
        });
        int n=graph.length;
        this.inMST=new boolean[n];
        inMST[0]=true;cut(0);
        while (!pq.isEmpty()){
            int[] edge=pq.poll();
            int to=edge[1];
            int weight=edge[2];
            if (inMST[to]){
                continue;
            }
            weightSum+=weight;
            inMST[to]=true;
            cut(to);
        }
    }

    private void cut(int s) {
        for (int[] edge:graph[s]){
            int to=edge[1];
            if (inMST[to]){
                continue;
            }
            pq.offer(edge);
        }
    }

    public int weightSum(){
        return weightSum;
    }

    public boolean allConnected(){
        for (int i=0;i<inMST.length;i++){
            if (!inMST[i]){
                return false;
            }
        }
        return true;
    }
}
