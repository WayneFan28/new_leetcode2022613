package Tree;

public class KthSmallest {//leetcode 230
    /**
     * Given the root of a binary search tree, and an integer k,
     * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     */
    int result=0,rank=0;
    public int kthSmallest(TreeNode root,int k){
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode root, int k) {
        if (root==null){
            return;
        }
        traverse(root.left, k);
        rank++;
        if (k == rank){
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }


}
