import java.util.Arrays;

public class Day23 {
// 	DAY 23
// Subarray Sum Equals K
// Shortest Unsorted Continuous Subarray
// TODO optimize
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        
        int i=0;
        while (i < nums.length && nums[i] == temp[i]) {
                i++;
        }
        int j = nums.length -1;
        while (j >= 0 && nums[j] == temp[j]) {
                j--;
        }
        
        return j - i + 1 > 0 ? j-i+1: 0;
    }
}
// Maximum Points You Can Obtain from Cards
// Max Consecutive Ones III
}
