

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/find-common-characters/


// https://leetcode.com/problems/third-maximum-number/

class q1 {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == firstMax || nums[i] == secondMax || nums[i] == thirdMax) continue;
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        
        return (int)(thirdMax == Long.MIN_VALUE ? firstMax: thirdMax);
    }
}

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class q2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i< nums.length;) {
            if (nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< nums.length; i++) {
            if (nums[i] != i+1) {
                result.add(i+1);
            }
        }
        return result;
    }
}


// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/



// https://leetcode.com/problems/assign-cookies/

class q4 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int count = 0;
        int i=0, j=0;
        while (i < g.length && j <s.length) {
            if (g[i] <= s[j]) {
                count++; i++; 
            }
            j++;
        }
        return count;
    }
}


// https://leetcode.com/problems/degree-of-an-array/


// https://leetcode.com/problems/can-place-flowers/
class q6 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i=0; i < flowerbed.length; i++) {
            if (flowerbed[i]==1) continue;
            boolean emptyLeftPlot = (i == 0 || flowerbed[i-1] != 1);
            boolean emptyRightPlot = (flowerbed.length-1 == i || flowerbed[i+1] != 1);
            
            if (emptyLeftPlot && emptyRightPlot) {
                count++;
                flowerbed[i]=1;
            }
        }
        return count >= n;
    }
}
// https://leetcode.com/problems/plus-one/


// https://leetcode.com/problems/single-number/
class q8 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i=1; i< nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

// https://leetcode.com/problems/single-number-ii/
class q9 {
	public int singleNumber(int[] nums) {
             if (nums.length <3) return nums[0];
             Arrays.sort(nums);
             if (nums[1] != nums[0]) return nums[0];
             int i=1;
             while (i < nums.length) {
                 if (nums[i] != nums[i-1])
                     return nums[i-1];
                 i+=3;
             }
             return nums[nums.length-1];
         }

}

// https://leetcode.com/problems/single-number-iii/


// https://leetcode.com/problems/multiply-strings/



// https://leetcode.com/problems/valid-tic-tac-toe-state/

// https://leetcode.com/problems/ones-and-zeroes/
