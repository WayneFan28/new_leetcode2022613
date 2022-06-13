package Tree;

public class ConstructBinaryTreeFromTraversal {//lt 105,106

    /**
     Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
     postorder is the postorder traversal of the same tree, construct and return the binary tree.
     */
    public TreeNode buildTreePreoderInoder(int[] preorder, int[] inorder) {//lt105

        return buildPreoderInoder(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);

    }

    private TreeNode buildPreoderInoder(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        int rootVal = preorder[preS];
        int rootIndex = 0;//The index of the root node in the inorder traversal array
        for (int i = inS; i <= inE; i++){
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        int leftSize = rootIndex - inS;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildPreoderInoder(preorder, preS + 1, preS + leftSize,
                inorder, inS, rootIndex - 1);
        root.right = buildPreoderInoder(preorder, preS + leftSize + 1, preE,
                inorder, rootIndex + 1, inE);
        return root;
    }

    public TreeNode buildTreeInoderPostOrder(int[] inorder, int[] postorder) {//lt 106
        return null;
    }
}
