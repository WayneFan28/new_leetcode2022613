package Tree;

public class BalancedBinaryTree {//leetcode 110
    /**
     Given a binary tree, determine if it is height-balanced.

     For this problem, a height-balanced binary tree is defined as:

     a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     */
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root){
        isBalancedDepth(root);
        return isBalanced;
    }

    private int isBalancedDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (!isBalanced){
            return Integer.MAX_VALUE;
        }
        int leftMax = isBalancedDepth(root.left);
        int rightMax = isBalancedDepth(root.right);
        if (Math.abs(rightMax - leftMax) > 1){
            isBalanced = false;
        }
        return 1 + Math.max(leftMax, rightMax);
    }
}
