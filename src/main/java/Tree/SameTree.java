package Tree;


/**
 Given the roots of two binary trees p and q,
 write a function to check if they are the same or not.
 Two binary trees are considered the same if they are structurally identical,
 and the nodes have the same value.
 */
public class SameTree {//leetcode 100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.right, root.left);
    }

    private boolean check(TreeNode right, TreeNode left) {
        if (right == null && left == null){
            return true;
        }
        if (right == null || left == null){
            return false;
        }
        if (right.val != left.val) {
            return false;
        }
        return check(right.right, left.left) && check(right.left, left.right);
//        if (!check(right.right,left.left)){
//            return false;
//        }
//        if (!check(right.left, left.right)){
//            return false;
//        }
//        return true;
    }
}
