package Graph;

import java.util.LinkedList;
import java.util.List;

public class AllPathSourceTarget {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph,0,path);
        return res;
    }

    private void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        path.addLast(i);
        int n=graph.length;
        if (i==n-1){
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int v:graph[i]){
            traverse(graph,v,path);
        }
        path.removeLast();
    }
}
