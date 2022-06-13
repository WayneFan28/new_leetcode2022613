package LinkedList;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head,int n){
        if (head==null||n==0){
            return null;
        }
        int length=0;
        while(head.next!=null){
            ListNode end=head.next;
            length++;
        }
        for (int i=0;i<length+1-n;i++){
            ListNode pre=head.next;
            pre.next=pre.next.next;
        }
        return head;
    }

}
