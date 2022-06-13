package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLeaves_ofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root){
        List<List<Integer>> res = new LinkedList<>();
        while (root != null){
            ArrayList<Integer> list = new ArrayList<>();
            root = recur(root, list);
            res.add(list);
        }
        return res;
    }

    private TreeNode recur(TreeNode root, ArrayList<Integer> list) {
        if (root == null){
            return null;
        }
        if (root.left == root.right && root.left == null){
            list.add(root.val);
            return null;
        }
        root.left = recur(root.left, list);
        root.right = recur(root.right, list);
        return root;
    }

}
