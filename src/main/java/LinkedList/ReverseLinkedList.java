package LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        ListNode node;
        while (head!=null){
            node=head;
            head=head.next;
            node.next=newHead;
            newHead=node;
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

