package LinkedList;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists  {
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0)return null;
        ListNode dummy = new ListNode(-1);
        ListNode p =dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode t1, ListNode t2) {
                return t1.val - t2.val;
            }
        });
        for (ListNode head : lists){
            if (head != null){
                pq.add(head);
            }
        }
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if (node.next!=null){
                pq.add(node.next);
            }
            p=p.next;
        }
        return dummy.next;
    }

    public int findKthLargest(int[] nums, int k){
        int len = nums.length;
        PriorityQueue<Integer> minTop = new PriorityQueue<>(k, (a, b) -> a -b);
        for (int i=0;i<k;i++){
            minTop.add(nums[i]);
        }
        for (int i=k;i<len;i++){
            Integer topEle = minTop.peek();
            if (nums[i]>topEle){
                minTop.poll();
                minTop.offer(nums[i]);
            }
        }
        return minTop.peek();
    }

    @Test
    public void test(){
        MergeKLists mm = new MergeKLists();
        int[] nums = {8,7,1,6,5,4,2,3,9};
        int kthLargest = mm.findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }
}
