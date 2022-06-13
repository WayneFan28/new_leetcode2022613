package Tree;

import java.util.LinkedList;
import java.util.List;

public class PathSum {

    /**
     Given the root of a binary tree and an integer targetSum,
     return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
     */
    int tempSum = 0;
    boolean hasSum = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {//leetcode112
        if (root == null){
            return false;
        }
        traverse(root,  targetSum);
        return hasSum;
    }
    private void traverse(TreeNode root, int targetSum) {
        if (root == null){
            return ;
        }
        tempSum += root.val;
        if (root.left == null && root.right == null){
            if (tempSum == targetSum) {
                hasSum = true;
            }
        }
        traverse(root.right,  targetSum);
        traverse(root.left,  targetSum);
        tempSum -= root.val;
    }

    public boolean hasPathSum_2(TreeNode root, int targetSum){
        if (root == null){
            return false;
        }
        if (root.left == root.right && root.val == targetSum){
            return true;
        }
        return hasPathSum_2(root.left, targetSum - root.val)
                || hasPathSum_2(root.right, targetSum - root.val);
    }

    /**
     Given the root of a binary tree and an integer targetSum,
     return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
     Each path should be returned as a list of the node values, not node references.
     */
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {//leetcode 113
        if (root == null) return res;
        traverse1(root, targetSum, new LinkedList<>());
        return res;
    }

    private void traverse1(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root == null) return;
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == root.right && root.left == null){
            if (targetSum == 0){
                res.add(new LinkedList<>(path));
            }
        }
        traverse1(root.left, targetSum, path);
        traverse1(root.right, targetSum, path);
        targetSum += path.pollLast();
    }
}
