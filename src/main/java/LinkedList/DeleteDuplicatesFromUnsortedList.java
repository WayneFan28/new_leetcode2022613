package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DeleteDuplicatesFromUnsortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){return head;}
        Map<Integer, Integer> map = new HashMap<>();int i=0;
        map.put(i,head.val);
        ListNode currentNode = head;
        while (head.next!=null){
            i++;
            if (map.containsKey(head.next.val)&&head.next.next==null){
                head.next = null;
            }else if (map.containsKey(head.next.val)){
                head.next=head.next.next;}
            else {
                map.put(i,head.next.val);
                head=head.next;
            }
            if (head.next==null){break;}
        }
        return currentNode;
    }


    public ListNode deleteDuplicates1(ListNode head){
        HashSet<Object> set = new HashSet<>();
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            set.add(cur.val);
            if (set.contains(cur.next.val)){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;}
}
