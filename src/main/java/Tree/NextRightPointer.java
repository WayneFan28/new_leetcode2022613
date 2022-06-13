package Tree;

public class NextRightPointer {
    private class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root){
        if (root==null){
            return null;
        }
        connectTwoNode(root.left,root.right);
        return root;
    }

    public void connectTwoNode(Node n1,Node n2){
        if (n1==null||n2==null){
            return;
        }
        n1.next=n2;
        connectTwoNode(n1.left,n1.right);
        connectTwoNode(n2.left,n2.right);
        connectTwoNode(n1.right,n2.left);
    }

}
