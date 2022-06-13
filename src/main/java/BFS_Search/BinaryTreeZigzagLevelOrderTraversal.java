package BFS_Search;

import Tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {//leetcode 103

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean right = true;
        while (!q.isEmpty()){
            int sz = q.size();
            List<Integer> temp = new LinkedList<>();
            while (sz-- > 0){
                //TreeNode cur = q.peek();
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
            if (right){
                res.add(temp);
            }else {
                Collections.reverse(temp);
                res.add(temp);
            }
            right = !right;
        }
        return res;
    }



}
