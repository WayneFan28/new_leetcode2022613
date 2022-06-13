package Tree;

public class BST_Tree {//leetcode 538
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    public boolean isValidBST(TreeNode root){
        return traverseBST(root, null, null);
    }

    private boolean traverseBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return traverseBST(root.left, min, root) && traverseBST(root.right, root, max);
    }

    public TreeNode searchBST(TreeNode root, int target){
//        if (root == null) return null;
//        if (root.val == target) return root;
//        TreeNode left = searchBST(root.left, target);
//        TreeNode right = searchBST(root.right, target);
//        return left != null ? left : right;

        if (root == null) return null;
        if (root.val > target) return searchBST(root.left, target);
        if (root.val < target) return searchBST(root.right, target);
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key){
        return null;
    }

}
