package Graph;

import java.util.LinkedList;
import java.util.List;

public class CanFinish {//leetcode 207
    boolean[] visited = new boolean[10000];
    boolean[] onPath = new boolean[10000];
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            traverse(graph, i);
        }
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]){
            hasCycle = true;
        }
        if (visited[s] || hasCycle){
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]){
            traverse(graph, t);
        }
        onPath[s] = false;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites){
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
