package Tree;

public class DiameterOfBinaryTree {//lt543
    private int res=0;
    public int diameterOfBinaryTree(TreeNode root){
        if (root==null||(root.left==null&&root.right==null)){
            return 0;
        }
        maxDepth(root);
        return res;
    }
    private int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        res=Math.max(res,leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth)+1;
        //return res;
    }
}
