// 	DAY 13

import java.util.HashSet;
import java.util.Set;

public class Day13 {
// Roman to Integer

// Palindrome Number
class q2 {
    public boolean isPalindrome(int x) {
        long y = x, r = 0;
        
        while (x > 0) {
            r = r*10 + x%10;
            x/=10;
        }
        return y==r;
    }
}
// Happy Number
class q3 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n > 1) {
            long sum = 0;
            while (n > 0) {
                sum += (n%10)*(n%10);
                n=n/10;
            }
            n = (int)sum;
            if (set.contains(n))
                break;
            set.add(n);
            
        }
        return n==1;
    }
}
// Power of Two


// Sqrt(x)


// Plus One
class q5 {
	public int[] plusOne(int[] digits) {
        int i=digits.length-1;
		while (i>=0) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
            i--;
		}

		digits = new int[digits.length+1];
		digits[0] = 1;
		return digits;
    }
}
}
