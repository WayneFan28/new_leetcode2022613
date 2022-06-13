package LinkedList;

import org.junit.Test;

public class LinkedListTest {

    @Test//MergeTwoSortedList
    public void test2(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.add(2);l1.add(4);l2.add(3);l2.add(4);
//        l1.print();l2.print();
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode l3 = mergeTwoSortedList.mergeTwoLists(l1,l2);
        l3.print();
    }
    @Test//DeleteDuplicatesFromSortedList
    public void test3(){//DeleteDuplicatesFromUnsortedList
        ListNode l1 = new ListNode(1);
        l1.add(6);l1.add(4);l1.add(2);l1.add(4);l1.add(6);l1.print();
        DeleteDuplicatesFromUnsortedList ddfs = new DeleteDuplicatesFromUnsortedList();
       //ListNode l2=ddfs.deleteDuplicates(l1);
        ListNode l2=ddfs.deleteDuplicates1(l1);
        System.out.println("------------------");
        l2.print();
    }

}
