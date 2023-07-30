import java.util.Stack;

public class Day11 {
	
// 	DAY 11
// Is Subsequence
class q1 {
    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;
        while (j<s.length() && i< t.length()) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
            i++;
        }
        
        return j == s.length();
    }
}

// Reverse String
class q2 {
    public void reverseString(char[] s) {
        for(int i=0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i-1];
            s[s.length - i-1] = temp;
        }
    }
}
// Reverse String II


// Reverse Words in a String III
class q3 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (String subString: s.split(" ")) {
            StringBuilder temp=new StringBuilder(subString);  
            temp.reverse();  
            sb.append(temp.toString() + " ");
        }
        return sb.toString().trim();
    }
}


// Isomorphic Strings
// Remove All Adjacent Duplicates In String
class q5 {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i=0; i< s.length(); i++) {
            if (!st.isEmpty() && st.peek() == s.charAt(i))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        
        StringBuilder str = new StringBuilder();
        while (!st.isEmpty()) {
            str.append(st.pop());
        }
        str.reverse();
        return str.toString();
    }
}
}
