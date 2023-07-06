// https://leetcode.com/problems/happy-number/

import java.util.HashSet;
import java.util.Set;

class q1 {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}


// https://leetcode.com/problems/power-of-two/

class q2 {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        return n != 0 && (n & (n-1)) == 0;
    }
}

// https://leetcode.com/problems/valid-anagram/

class q3 {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())
            return false;

        int[] freq = new int[26];

        for (int i=0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i=0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }

        for (int i=0; i < 26; i++) {
            if (freq[i] != 0) 
                return false;
        }

        return true;
    }
}

// https://leetcode.com/problems/ugly-number/

class q4 {
    public boolean isUgly(int n) {
            if (n==0) return false;
            while (n%5 == 0)
                n = n/5;
            while (n%3 == 0)
                n = n/3;
            while (n%2 == 0)
                n = n/2;
            if (n == 1) return true;
            return false;
    }
}

// https://leetcode.com/problems/move-zeroes/

class q5 {
	public void moveZeroes(int[] nums) {
		int count=0;
		int i=0;
		for (;count<nums.length;) {
			if (nums[count] != 0) {
				nums[i] = nums[count];
				i++; 
			} 
			count++;
		}
		
		while(i<nums.length) {
			nums[i++] =0;
		}
	}
}


// https://leetcode.com/problems/reverse-vowels-of-a-string/

class q6 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        int start = 0, end = s.length() - 1;
        char[] result = s.toCharArray();
        while (start < end) {
            while (start < end && !(result[start] == 'A' || result[start] == 'a' || result[start] == 'E' || result[start] == 'e' || result[start] == 'I' || result[start] == 'i' || result[start] == 'O' || result[start] == 'o'  || result[start] == 'U' || result[start] == 'u')) {
                start++;
            }
            
            while (start < end && !(result[end] == 'A' || result[end] == 'a' || result[end] == 'E' || result[end] == 'e' || result[end] == 'I' || result[end] == 'i' || result[end] == 'O' || result[end] == 'o'  || result[end] == 'U' || result[end] == 'u')) {
                end--;
            }
            
            char temp = result[start];
            result[start] = result[end];
            result[end] = temp;
            start++;
            end--;
        }
        return new String(result);
    }
}

// https://leetcode.com/problems/third-maximum-number/

class q7 {
    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE, m2 = Long.MIN_VALUE, m3 = Long.MIN_VALUE;
        for (int i=0; i< nums.length; i++) {
            if (m1 == nums[i] || m2 == nums[i] || m3 == nums[i]) continue;
            if (nums[i] > m1) {
                m3 = m2;
                m2 = m1; 
                m1  = nums[i]; 
            } else if (nums[i] > m2) {
                m3 = m2;
                m2 = nums[i];
            } else if (nums[i] > m3) {
                m3 = nums[i];
            }
        }
        if (m3 == Long.MIN_VALUE) return (int) m1;
        else return (int) m3;
        
    }
}

// https://leetcode.com/problems/find-the-difference/

class q8 {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        for (char ch: t.toCharArray()) {
            freq[ch-'a']--;
            if (freq[ch-'a'] < 0) {
                return ch;
            }
        }
        return (char) 'a';
    }
}

// https://leetcode.com/problems/add-digits/

class q9 {
    public int addDigits(int num) {
        if (num< 10) return num;
        while (num/10 != 0) {
            num = sumOfDigits(num);
        }
        return num;
    }
    
    public int sumOfDigits(int num) {
        int sum =0;
        while (num!= 0) {
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }
}

// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/

class q10 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder("");
        int n = 0; 
        for (char ch: s.toCharArray()) {
            int curr = ch-'a'+1;
            sb.append("" + curr);
        }
        for (int i=0; i<sb.toString().length(); i++) {
            int curr = Integer.parseInt("" + sb.toString().charAt(i));
            n += curr;   
        }
        k--;
        while (k > 0) {
            int sum = 0;
            while (n != 0) {
                sum += n%10;
                n= n/10;
            }
            n = sum;
            k--;
        }
        
        return n;
        
    }
}

