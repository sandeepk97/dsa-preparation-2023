

// DAY 2
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
// Remove Duplicates from Sorted Array
// #TODO efficient 
class q1 {
	public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n: nums) {
            if (i==0 || nums[i-1] != n) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public int removeDuplicatesWithExtraSpace(int[] nums) {
        int i = 0;
        Set<Integer> set = new HashSet<>();
        for (int j=0; j<nums.length; j++) {
            if (!set.contains(nums[j])) {
                nums[i++] = nums[j];
            }
            set.add(nums[j]);
        }
        return set.size();
    }
}



// Remove Duplicates from Sorted Array II
class q2 {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for (int n: nums) {
            if (i==0 || i==1 || (nums[i-2] != n))
                nums[i++] = n;
        }
        return i;
    }
}
// Find All Numbers Disappeared in an Array


// Intersection of Two Arrays
class q4 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] output = new int[nums1.length];
        int i=0, j=0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (index>0) {
                if (output[index-1] == nums1[i]) {
                    i++; continue;
                }
                if (output[index-1] == nums2[j]) {
                    j++; continue;
                }
            }
                
            if (nums1[i] < nums2[j]) {
                i++;
            } else  if (nums1[i] > nums2[j]) {
                j++;
            } else {
                output[index++] = nums1[i++]; j++;
            }
        }
        return Arrays.copyOf(output, index);
    }
}
// Intersection of Two Arrays II
class q5 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);  Arrays.sort(nums2);
        int i=0, j=0, index=0;
        int[] intersection = new int[nums1.length];
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                intersection[index++] = nums1[i++];
                j++;
            }
        }
        
        return Arrays.copyOf(intersection, index);
    }
}
// Maximum Population Year
// #TODO try efficient approach

// Find Pivot Index
class q7 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum += num;
        
        int leftSum = 0;
        for (int i=0; i< nums.length; i++) {
            if (leftSum == sum-leftSum-nums[i])
                return i;
            
            leftSum += nums[i];
        }
        
        return -1;
    }
}


public class Day2 {
	
}
