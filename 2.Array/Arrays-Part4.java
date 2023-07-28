

import java.util.ArrayList;
import java.util.List;

// 1. https://leetcode.com/problems/add-binary/
class q1 {
    public String addBinary(String a, String b) {
        StringBuilder sb= new StringBuilder();
        int sum = 0, carry = 0;
        for (int i=a.length()-1,j=b.length()-1; i>=0 || j>=0; ) {
            int x = i>=0 ? a.charAt(i) - '0' : 0;
            int y = j>=0 ? b.charAt(j) - '0' : 0;
            
            sum = (x+y + carry)%2;
            carry = (x+y + carry)/2;
            sb.append(sum);
            i--; j--;
        }
        
        if (carry != 0)
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}


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
class q5 {
    public int countNegatives(int[][] grid) {
        int i=0, j= grid[0].length-1, count = 0;
        while (i < grid.length) {
            while (j>=0 && grid[i][j] < 0) {
                 j--;
            }
            count += grid[0].length-1-j;
            i++;
        }
        return count;
    }
}

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

class q8inPlace {
    public int[] sortArrayByParityII(int[] nums) {
        int i=0, j=1;
        while (i <nums.length && j<nums.length) {
            while (i < nums.length && nums[i]%2 == 0) {
                i+=2;
            }
            while (j < nums.length && nums[j]%2 == 1) {
                j+=2;
            }
            if (i < nums.length && j < nums.length && nums[i]%2 == 1 && nums[j]%2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i+=2; j+=2;
        }
        return nums;
    }
}

// 9. https://leetcode.com/problems/duplicate-zeros/
class q9 {
    public void duplicateZeros(int[] arr) {
        int numOfZeroes = 0;
        for (int num: arr)
            if (num == 0)
                numOfZeroes++;
        int last = arr.length+numOfZeroes-1;
        int i=arr.length-1;
        while (i!=last) {    
            if (arr[i] !=0) {
                if (last < arr.length) {
                    arr[last] = arr[i];
                }
            }
            else {
                if (last < arr.length) {
                    arr[last] = arr[i];
                }
                last--;
                if (last < arr.length) {
                    arr[last] = arr[i];
                }
            }
            i--;
            last--;
        }
        
    }
}

// 10. https://leetcode.com/problems/contains-duplicate-iii/

// 11. https://leetcode.com/problems/max-consecutive-ones/
class q11 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0, maxCount = 0;
        for (int num: nums) {
            if (num!= 0) {
                currCount++;
            } else {
                currCount = 0;
            }
            maxCount = Math.max(currCount, maxCount);
        }
        return maxCount;
    }
}

// 12. https://leetcode.com/problems/max-consecutive-ones-iii/
class q12 {
    public int longestOnes(int[] nums, int k) {
        int maxOnes = 0, zeroesCount = 0;
        for (int i=0, j=0; i<=j && j< nums.length; j++) {
            if (nums[j] == 0)
                zeroesCount++;
            
            while (zeroesCount > k) {
                if (nums[i] == 0)
                    zeroesCount--;
                i++;
            }
            
            maxOnes = Math.max(maxOnes, j-i+1);
        }
        return maxOnes;
    }
}


// 13. https://leetcode.com/problems/online-election/
