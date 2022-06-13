package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void add(int newval){
        ListNode newNode = new ListNode(newval);
        if (this.next==null){
            this.next=newNode;
        }else{
            this.next.add(newval);
        }

    }
    public void print(){
        System.out.println(this.val);
        if (this.next!=null){
            System.out.println("-->");
            this.next.print();
        }
    }
}
