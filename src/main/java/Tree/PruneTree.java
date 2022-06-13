package Tree;

public class PruneTree {
    public TreeNode pruneTree(TreeNode root){
        return containsOne(root)? root:null;
    }

    private boolean containsOne(TreeNode node) {
        if (node==null){
            return false;
        }
        boolean le = containsOne(node.left);
        boolean ri = containsOne(node.right);
        if (!le){
            node.left=null;
        }
        if (!ri){
            node.right=null;
        }
        return node.val==1||le||ri;
    }
}
