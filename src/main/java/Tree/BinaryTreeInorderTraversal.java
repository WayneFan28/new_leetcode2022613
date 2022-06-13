package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
        public List<Integer> inorderTraversal1(TreeNode root){
            ArrayList<Integer> res = new ArrayList<>();
            accessTree(root,res);
            return res;
        }

        private void accessTree(TreeNode root, List<Integer> res) {
                if (root==null){
                    return;
                }
                accessTree(root.left, res);
                res.add(root.val);
                accessTree(root.right,res);
        }

        public List<Integer> inorderTraversalWithLoop(TreeNode root){
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (root!=null||!stack.isEmpty()){
                while (root!=null){
                    stack.push(root);
                    root=root.left;
                }
                root=stack.pop();
                res.add(root.val);
                root=root.right;
            }
            return res;
        }

}
