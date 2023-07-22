
// DAY 1

import java.util.Map;
import java.util.HashMap;

// Two Sum
// https://leetcode.com/problems/two-sum/
class q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {(int)map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

// Best Time to Buy and Sell Stock 
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class q2 {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int price: prices) {
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }
}
// Majority Element
// https://leetcode.com/problems/majority-element/
class q3 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer result = null;
        for (int num: nums) {
            if (result != null) {
                count += (num == result) ? 1: -1;
            }
            if (count == 0) {
                result = num;
                count=1;
            }
        }
        return result;
    }
}

// Move Zeroes
// https://leetcode.com/problems/move-zeroes/
class q4 {
    public void moveZeroes(int[] nums) {
        int i=0, j=0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
// Squares of a Sorted Array
// https://leetcode.com/problems/squares-of-a-sorted-array/
class q5 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right= nums.length-1, i=nums.length-1;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i--] = nums[right]* nums[right];
                right--;
            } else {
                result[i--] = nums[left]* nums[left];
                left++;
            }
        }
        
        return result;
        
    }
}


// Merge Sorted Array
// https://leetcode.com/problems/merge-sorted-array/

class q6 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>=0 && j>=0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else 
                nums1[k--] = nums2[j--];
        }
        
        while(i>=0) {
            nums1[k--] = nums1[i--];
        }
        
        while(j>=0) {
            nums1[k--] = nums2[j--];
        }
        
    }
}


public class Day1 {
	
}
