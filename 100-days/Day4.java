
// DAY 4
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day4 {
class q1 {

	// Find Common Characters
	public List<String>  commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        int[][] charsFreq = new int[words.length][26];
        for (int i=0; i< words.length; i++) {
            for (int j=0; j< words[i].length(); j++) {
                charsFreq[i][words[i].charAt(j) - 'a']++;
            }
        }
        
        for (int i=0; i< words.length; i++) {
            for (int j=0; j<26;j++) {
                minFreq[j] = Math.min(minFreq[j] , charsFreq[i][j]);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i=0; i< minFreq.length; i++) {
            while (minFreq[i]-- > 0) {
                result.add("" + (char) (i+'a'));
            }
        }
        return result;
    }
}

// Sum of All Odd Length Subarrays 
// #TODO



// Range Sum Query - Immutable Shuffle the Array
class NumArray {

    int[] prefixSum;
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        for (int i=0; i<nums.length;i++) {
            prefixSum[i] = nums[i] + (i>0 ? prefixSum[i-1] : 0);
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right] - (left>0 ? prefixSum[left-1]: 0);
    }
}
// Max Consecutive Ones
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
// Sort Array By Parity
    public int[] sortArrayByParity(int[] nums) {
        int i=0, j=nums.length-1;
        while (i<j) {
            while (i<j && nums[i] %2==0)
                i++;
            while (i<j && nums[j] %2!=0)
                j--;
            
            if (i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++; j--;
        }
        return nums;
}



	public static void main(String[] args) {
		String[] words = new String[]{"bella","label","roller"};
		List<String> result = new Day4().new q1().commonChars(words);
		System.out.println(result);
	}
}
