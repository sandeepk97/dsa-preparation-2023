// 	DAY 20

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day20 {
// 3Sum
class q1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i< nums.length-2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            int j=i+1, k = nums.length-1;
            while (j<k) {
                int mid = j + (k-j)/2;
                if (nums[j] + nums[k] == -1*nums[i]) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                } else if (nums[j] + nums[k] < -1*nums[i]) {
                    j++;
                } else {
                    k--;
                }
                
                while (j > i+1 && j<nums.length && nums[j] == nums[j-1])
                    j++;
                while (k > j && k<nums.length-1 && nums[k] == nums[k+1])
                    k--;
            }
            
        }
        return result;
    }
}
// 3Sum Closest
class q2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2], absoluteDiff = Integer.MAX_VALUE;
        for (int i=0; i< nums.length-2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            int j=i+1, k = nums.length-1;
            while (j<k) {
                int mid = j + (k-j)/2;
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum-target) < absoluteDiff) {
                    absoluteDiff = Math.abs(sum-target);
                    result = sum;
                }
                
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
                
                while (j > i+1 && j<nums.length && nums[j] == nums[j-1])
                    j++;
                while (k > j && k<nums.length-1 && nums[k] == nums[k+1])
                    k--;
            }
            
        }
        return result;
    }
}
// Non-decreasing Array
// TODO


// Product of Array Except Self
}
