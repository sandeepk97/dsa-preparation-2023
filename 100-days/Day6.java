// DAY 6

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Day6 {
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
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

// Intersection of Two Linked Lists
// TODO without difference in length
class q1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode currA = headA, currB = headB;
        while (currA != null) {
            lenA++; currA = currA.next;
        }
        while (currB != null) {
            lenB++; currB = currB.next;
        }
        
        if (lenA > lenB) {
            ListNode temp = headB;
            headB = headA;
            headA = temp;
        }
        
        currA = headA;
        currB = headB;
        int count = Math.abs(lenB-lenA);
        
        while (count > 0) {
            currB = currB.next;
            count--;
        }
        
        while (currA != null && currB != null) {
            if (currA == currB)
                return currA;
            currA = currA.next;
            currB = currB.next;
        }
        
        return null;
    }
}

// Linked List Cycle
class q2 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (slow == null || fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return slow == fast;
    }
}


// Valid Parentheses
class q3 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;
                char popped = st.pop();
                if (ch == ')' && popped != '(')
                    return false;
                else if (ch == '}' && popped != '{')
                    return false;
                else if (ch == ']' && popped != '[')
                    return false; 
            }
        }
        
        return st.isEmpty();
    }
}


// Implement Queue using Stacks 
class MyQueue {

    Stack<Integer> s1, s2;
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s2.size() == 0) {
            while (s1.size() != 0) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if (s2.size() == 0) {
            while (s1.size() != 0) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.size() == 0 && s2.size() == 0;
    }
}


// Backspace String Compare 
class q5 {
	//TODO
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>(), s2 = new Stack<>();
        int i=0, j=0;
        for (; i<s.length();) {
            if (s.charAt(i) == '#') {
                if (!s1.isEmpty())
                    s1.pop();
            } else
                s1.push(s.charAt(i));
            i++;
        }
        
        for (; j<t.length();) {
            if (t.charAt(j) == '#') {
                if (!s2.isEmpty())
                    s2.pop();
            } else
                s2.push(t.charAt(j));
            j++;
        }
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop()) return false;
        }
        
        return s1.isEmpty() && s2.isEmpty();
    }
}


// Next Greater Element I
class q6 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> h = new HashMap<>();
        int i=0;
        while (i < nums2.length) {
            while (!st.isEmpty() && nums2[i] > st.peek()) {
                h.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
            i++;
        }
        
        int[] result = new int[nums1.length];
        for (i=0; i<nums1.length; i++) {
            result[i] = h.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
	
}
