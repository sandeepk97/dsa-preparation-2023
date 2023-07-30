
// DAY 10

public class Day10 {
// 	Valid Palindrome
// Valid Palindrome II
// Longest Palindrome
class q3 {
    public int longestPalindrome(String s) {
        int[] freqCount = new int[128];
        for (int i=0; i< s.length(); i++) {
            freqCount[s.charAt(i) - 'A']++;
        }
        
        int maxLength = 0, isOdd = 0;
        for (int i=0; i<128; i++) {
            maxLength += freqCount[i]/2;
            if (isOdd == 0 && freqCount[i]%2==1) isOdd = 1;
        }
        
        if (maxLength >= 1) {
            return 2* maxLength + isOdd;
        } return isOdd;
    }
}
// Longest Common Prefix
// Valid Anagram
// First Unique Character in a String
}
