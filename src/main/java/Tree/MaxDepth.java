package Tree;

public class MaxDepth {//lt104
    /**
     Given the root of a binary tree, return its maximum depth.
     */
    int depth = 0, res = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null){
            return;
        }
        depth++;
        res = Math.max(res, depth);
        traverse(root.right);
        traverse(root.left);
        depth--;
    }
}
