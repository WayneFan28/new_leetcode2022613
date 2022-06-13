package Tree;

public class FlattenBinaryTreeToLinkedList {//114
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //1. The left and right subtrees have been flattened into a linked list
        TreeNode left = root.left;
        TreeNode right = root.right;
        //2. Use the left subtree as the right subtree
        root.left = null;
        root.right = left;
        //3. Connect the original right subtree to the end of the current right subtree
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}

