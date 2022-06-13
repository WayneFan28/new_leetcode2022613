package BFS_Search;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointers {

    /**
     You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
     The binary tree has the following definition:Populate each next pointer to point to its next right node.
     If there is no next right node, the next pointer should be set to NULL.
     */
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++){
                Node cur = queue.poll();
                if (i < sz - 1)cur.next = queue.peek();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }
}
