package Tree;

public class BST_ToGst {

    /**
     * Given the root of a Binary Search Tree (BST),
     * convert it to a Greater Tree such that every key of the original
     * BST is changed to the original key plus the sum of all keys greater
     * than the original key in BST.
     */
    public TreeNode bstToGst(TreeNode root) {//leetcode 1038
        traverse(root);
        return root;
    }
    int sum = 0;
    private void traverse(TreeNode root) {
        if (root == null){
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
