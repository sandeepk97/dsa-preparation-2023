
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Day25 {
// 	DAY 25
// Remove Nth Node From End of List
// Delete Node in a Linked List
class q2 {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        ListNode prev=null;
        while (node.next != null) {
            node.val = node.next.val;
            prev=node;
            node = node.next;
        }
        if (prev != null)
            prev.next = null;
    }

	public void deleteNode1(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
// Remove Duplicates from Sorted List II
// Next Greater Node In Linked List
}
