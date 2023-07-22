

import java.util.ArrayList;
import java.util.List;

// 1. https://leetcode.com/problems/add-binary/



// 2. https://leetcode.com/problems/shuffle-the-array/


class q2 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        
        for (int i=0, j=0; i < result.length && j < result.length; i+=2) {
            result[i] = nums[j];
            result[i+1] = nums[j+n];
            j++;
        }
        
        return result;
    }
}

// class q2 {
//     public int[] shuffle(int[] nums, int n) {
//         int[] result = new int[2 * n];
//         for (int i = 0; i < n; ++i) {
//             result[2 * i] = nums[i];
//             result[2 * i + 1] = nums[n + i];
//         }
//         return result;
//     }
// }

// 3 https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

class q3 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Find out the greatest number of candies among all the kids.
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(candy, maxCandies);
        }
        // For each kid, check if they will have greatest number of candies
        // among all the kids.
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}

// 4. https://leetcode.com/problems/sum-of-all-subset-xor-totals/

class q4 {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    public int helper(int[] nums, int index, int currentXor) {
        if (index == nums.length)
            return currentXor;
        
        int xorWithCurrentElement = helper(nums, index+1, currentXor ^ nums[index]);
        int xorWithoutCurrentElement = helper(nums, index+1, currentXor);
        return xorWithCurrentElement + xorWithoutCurrentElement;
    }
}

// 5. https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

// 6. https://leetcode.com/problems/three-consecutive-odds/
class q6 {
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

// 7. https://leetcode.com/problems/decode-xored-array/
class q7 {
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length+1];
        result[0] = first;
        for (int i=1; i< result.length; i++) {
            result[i] = encoded[i-1] ^ result[i-1];
        }
        return result;
    }
}

// 8. https://leetcode.com/problems/sort-array-by-parity-ii/

class q8 {
	// ##TODO sort in place
    public int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int i=0, j=1, k=0;
        while (k < nums.length) {
            if (nums[k] %2 != 0) {
                result[j] = nums[k++];
                j+=2;
            } else {
                result[i] = nums[k++];
                i+=2;
            }
        }
        return result;
    }
}

// 9. https://leetcode.com/problems/duplicate-zeros/

// 10. https://leetcode.com/problems/contains-duplicate-iii/

// 11. https://leetcode.com/problems/max-consecutive-ones/

// 12. https://leetcode.com/problems/max-consecutive-ones-iii/

// 13. https://leetcode.com/problems/online-election/
