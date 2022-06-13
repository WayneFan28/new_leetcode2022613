package Tree;

import java.util.LinkedList;

public class BinarySerialize {
////    // Encodes a tree to a single string.
    String SEP = ",", NULL = "#";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        //sb.append('[');
        seria(root, sb);
        //sb.append(']');
        return sb.toString();
    }

    private void seria(TreeNode root, StringBuilder sb) {
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        seria(root.left, sb);
        seria(root.right, sb);
    }

    ////
////    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)){
            nodes.addLast(s);
        }
        return deseria(nodes);
    }

    private TreeNode deseria(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deseria(nodes);
        root.right = deseria(nodes);
        return root;
    }
}
