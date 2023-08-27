
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

public class Day27 {
// 	DAY 27
// Swap Nodes in Pairs
class q1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            prev.next = next;
            next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
// Odd Even Linked List


// Partition List
/**
 * Definition for singly-linked list.
 */
class q3 {
    public ListNode partition(ListNode head, int x) {
        ListNode lessThan = new ListNode(0), result = lessThan;
        ListNode greaterThan = new ListNode(0), greatThan1 = greaterThan;
        while (head != null) {
            if (head.val < x) {
                lessThan.next = new ListNode(head.val);
                lessThan = lessThan.next;
            } else {
                greaterThan.next = new ListNode(head.val);
                greaterThan = greaterThan.next;
            }
            head = head.next;
        }        
        
        lessThan.next = greatThan1.next;
        return result.next;
    }
}
}
