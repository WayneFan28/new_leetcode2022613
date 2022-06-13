package LinkedList;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedList {//leetcode 83
    public ListNode deleteDuplicates(ListNode head){
        HashSet<Object> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null&&cur.next!=null){
            set.add(cur.val);
            if (set.contains(cur.val)){
                cur.next=cur.next.next;
            }else {
             cur=cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head){
        if (head==null) return null;
        ListNode slow=head, fast=head;
        while (fast!=null){
            if (fast.val!=slow.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        slow.next=null;
        return head;
    }
}
