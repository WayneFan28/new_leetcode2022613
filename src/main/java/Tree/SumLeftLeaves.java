package Tree;

public class SumLeftLeaves {

    /**
     Given the root of a binary tree, return the sum of all left leaves.
     A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
     */
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            traverse(root);
            return sum;
        }
        int sum = 0;
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            traverse(root.left);
            traverse(root.right);
        }
    }
}
