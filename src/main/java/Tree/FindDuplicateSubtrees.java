package Tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateSubtrees {//leetcode 652
    HashMap<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root) {
        if (root==null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left+","+right+","+root.val;
        int count=memo.getOrDefault(subTree,0);
        if (count==1){
            res.add(root);
        }
        memo.put(subTree,count+1);
        return subTree;
    }
}
