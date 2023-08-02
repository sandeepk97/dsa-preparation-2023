public class Day15 {
	// DAY 15

	// https://leetcode.com/problems/add-binary/
	
	// https://leetcode.com/problems/counting-bits/

	// https://leetcode.com/problems/number-of-1-bits/

	// https://leetcode.com/problems/single-number/

	// https://leetcode.com/problems/missing-number/
	class q5 {
		public int missingNumber(int[] nums) {
			for (int i=0; i<nums.length; i++) {
				while (nums[i] != i && nums[i] != nums.length) {
					int temp = nums[nums[i]];
					nums[nums[i]] = nums[i];
					nums[i] = temp;
				}
			}
			
			int i=0;
			for (; i<nums.length; i++) {
				if (i!=nums[i])
					return i;
			}
			return i;
		}
	}


	// https://leetcode.com/problems/reverse-bits/
	// TODO

	// https://leetcode.com/problems/hamming-distance/
	class q7 {
		public int hammingDistance(int x, int y) {
			int count = 0, n = x^y;
			for (int i=0; i< 32; i++) {
				if ((n&1) != 0) {
					count++;
				}
				n = n>>1;
			}
			return count;
		}
	}
}
