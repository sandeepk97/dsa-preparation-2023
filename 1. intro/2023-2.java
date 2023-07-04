// 1. Reverse the Number like 153 => 351 . Numbers can be negative

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q1 {
	public int reverse(int n) {
		int res = 0;
		int a=n;
		while (a != 0) {
			res = res * 10 + a%10;
			a = a/10;
		}
		return n>0 ? res: -1 * res;
	}
}

// 2. https://practice.geeksforgeeks.org/problems/pascal-triangle0652/1
class Q2 {
	ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<ArrayList<Long>> result = new ArrayList<>();
        result.add(new ArrayList<Long>(Arrays.asList(1L)));
        result.add(new ArrayList<Long>(Arrays.asList(1L, 1L)));
        for (int i = 2; i < n ; i++) {
            ArrayList<Long> curr = new ArrayList<>();
            curr.add(1L);
            for (int j = 0; j < result.get(i - 1).size() - 1; j++) {
                curr.add(((result.get(i - 1).get(j)*1L)%1000000007 + (result.get(i - 1).get(j + 1)*1L)%1000000007)%1000000007);
            }
            curr.add(1L);
            result.add(curr);
        }
        return result.get(n - 1);
    }
}


// 3. https://leetcode.com/problems/richest-customer-wealth

class Q3 {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = -1;
        for (int[] row: accounts) {
            int wealth = 0;
            for (int col: row){
                wealth+=col;
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }
}

// 4. https://leetcode.com/problems/running-sum-of-1d-array/

class Q4 {
    public int[] runningSum(int[] nums) {
        if (nums.length <= 1) return nums;
        for (int i=1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }
}

// 5. https://leetcode.com/problems/jewels-and-stones

class Q5 {
    public int numJewelsInStones(String jewels, String stones) {
        int[] freq = new int[128];
        for (char ch: jewels.toCharArray()) {
            freq[ch - 'A']++;
        }
        
        int count = 0;
        for (char ch: stones.toCharArray()) {
            if (freq[ch - 'A'] > 0)
                count++;
        }
        return count;
    }
}

// 6. https://leetcode.com/problems/minimum-absolute-difference

class Q6 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i=1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i=1; i < arr.length; i++) {
            if (minDiff ==  arr[i] - arr[i-1]) {
                result.add(new ArrayList<>(Arrays.asList(arr[i-1], arr[i])));
            }
        }
        return result;
    }
}

// 7. https://leetcode.com/problems/three-consecutive-odds

class Q7 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i=0; i< arr.length; i++) {
            if ((arr[i] & 1) != 0) {
                count++;
                if (count>=3)
                    return true;
            } else
                count = 0;
        }
        return false;
    }
}


// 8. https://leetcode.com/problems/move-zeroes

class Solution {
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