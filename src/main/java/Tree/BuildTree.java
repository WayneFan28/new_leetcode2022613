package Tree;

public class

BuildTree {//leetcode105
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        int rootVal=preorder[preS];
        int index=0;
        for (int i=inS;i<=inE;i++){
            if (inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        int leftSize=index-inS;
        TreeNode root = new TreeNode(rootVal);
        root.left=build(preorder,preS+1,preS+leftSize,inorder,inS,index-1);
        root.right=build(preorder,preS+leftSize+1,preE,inorder,index+1,inE);
        return root;
    }
}
