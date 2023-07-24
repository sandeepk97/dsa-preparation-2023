
// DAY 5

public class Day5 {
/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class q1 {
	// Reverse Linked List
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        if (prev == null) return head;
        else return prev;
    }
}


// Remove Linked List Elements 
class q2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
// Remove Duplicates from Sorted List 
class q3 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head, prev = head;
        while (prev!= null) {
            curr = prev.next;
            while (curr!= null && curr.val == prev.val)
                curr = curr.next;
            prev.next = curr;
            prev = prev.next;
        }
        return head;
    }
}

// Merge Two Sorted Lists
class q4 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (list1!= null && list2!= null) {
            if (list1.val > list2.val) {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            result = result.next;
        }
        
        if (list1 != null)
            result.next = list1;
        else
            result.next = list2;
        
        return head.next;
    }
}
// Middle of the Linked List 
class q5 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
// Palindrome Linked List
class q6 {
	//TODO recursive approach without modifying list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev == null ? head: prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode middle = head, fast = head;
        while (fast!= null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }
        if (fast!= null)
            middle = middle.next;
        ListNode rlist = reverseList(middle);
        while (rlist != null && head != null) {
            if (rlist.val != head.val) {
                 return false;
            }
               
            rlist = rlist.next; 
            head = head.next;
        }
        return true;
    }
}
}
