package Tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {//leetcode 199

    /**
     Given the root of a binary tree, imagine yourself standing on the right side of it,
     return the values of the nodes you can see ordered from top to bottom
     */
    public List<Integer> rightSideView_BFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode last = queue.peek();
            for (int i = 0; i < size; i++){
                TreeNode curNode = queue.poll();
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
            }
            res.add(last.val);
        }
        return res;
    }
}
