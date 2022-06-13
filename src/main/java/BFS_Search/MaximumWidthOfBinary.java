package BFS_Search;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumWidthOfBinary {

    private class Pairnode{

        TreeNode node;
        int id;

        public Pairnode(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root){
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<Pairnode> queue = new ArrayDeque<>();
        queue.offer(new Pairnode(root, 1));
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int start = 0, end = 0;
            for (int i = 0; i < queueSize; i++){
                Pairnode curPairnode = queue.poll();
                TreeNode curNode = curPairnode.node;
                int curId = curPairnode.id;
                if (i == 0) start = curId;
                if (i == queueSize - 1) end = curId;

                if (curNode.left != null){
                    queue.offer(new Pairnode(curNode.left, curId * 2));
                }
                if (curNode.right != null){
                    queue.offer(new Pairnode(curNode.right, curId * 2 + 1));
                }
                maxWidth = Math.max(maxWidth, end - start + 1);
            }
        }
        return maxWidth;
    }
}
