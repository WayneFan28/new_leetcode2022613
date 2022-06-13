package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {//lt102
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int cnt = q.size();
            List<Integer> temp = new LinkedList<>();
            while (cnt-- > 0){
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
            res.add(temp);
        }
        return res;
    }
}
