package BFS_Search;
import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBFS {
    int min_depth = Integer.MAX_VALUE;
    public int minDepth_DFS(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        if (root.left != null){
            min_depth = Math.min(minDepth_DFS(root.left), min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth_DFS(root.right), min_depth);
        }
        return min_depth + 1;
    }

    public int minDepth_BFS(TreeNode root){
        if (root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for (int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
                //depth++;
            }
            depth++;
        }
        return depth;
    }
}
