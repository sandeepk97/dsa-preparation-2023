
// https://leetcode.com/problems/move-zeroes/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class q1 {
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

// https://leetcode.com/problems/contains-duplicate/

class q2 {
    public boolean containsDuplicate(int[] nums) {
         Set<Integer> s = new HashSet<>();
        
        for (int i: nums)
            if (!s.add(i)) 
                return true;
        return false;
    }
}

// https://leetcode.com/problems/contains-duplicate-ii/
class q3 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                if (Math.abs(mp.get(nums[i]) - i) <= k)
                    return true;
            }
            mp.put(nums[i], i);
        }
        return false;
    }
}


// https://leetcode.com/problems/summary-ranges/
class q4 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            // Keep iterating until the next element is one more than the current element.
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                ranges.add(start + "->" + nums[i]);
            } else {
                ranges.add(String.valueOf(start));
            }
        }

        return ranges;
    }
}

// https://leetcode.com/problems/range-sum-query-immutable/

class q5 {
    int[] prefixSum;

    public void NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i=1; i< nums.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right] - (left == 0 ? 0: prefixSum[left-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

// https://leetcode.com/problems/range-sum-query-2d-immutable/

// https://leetcode.com/problems/remove-element/

class q6 {
    public int removeElement(int[] nums, int val) {
        int index = 0, count = 0;
        for (;count < nums.length;) {
            if (nums[count]!= val) {
                nums[index] = nums[count];
                index++;
            }
            count++;
        }
        return index;
    }
}

// https://leetcode.com/problems/intersection-of-two-arrays/
class q7 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i=0, j= 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {  set.add(nums1[i]); i++; j++;  }
        }
        
        int[] result = new int[set.size()];
        i=0;
        for (Integer num: set) {
            result[i++] = num;
        }
        return result;
     }
}


// https://leetcode.com/problems/intersection-of-two-arrays-ii/

// https://leetcode.com/problems/next-greater-element-i/

// https://leetcode.com/problems/next-greater-element-ii/

// https://leetcode.com/problems/next-greater-element-iii/

// https://leetcode.com/problems/rank-teams-by-votes/

// https://leetcode.com/problems/reduce-array-size-to-the-half/

