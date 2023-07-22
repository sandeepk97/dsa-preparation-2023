public class Solution {
		public static int longestSubarray(int[] nums) {
			int maxCount = 0, i=0, zeroesCount = 0, currCount = 0;
			while (i < nums.length) {
				if (nums[i] == 1) {
					currCount++;
					maxCount = Math.max(currCount, maxCount);
				} else {
					if (zeroesCount == 0) {
						zeroesCount = 1;
						currCount++;
						maxCount = Math.max(currCount, maxCount);
					} else {
						maxCount = Math.max(currCount, maxCount);
						zeroesCount = 0;
						currCount = 0;
					}
				}
				System.out.println(i + " " + currCount + " " + maxCount);
				i++;
			}
			return maxCount -1;
		}

		public static void main(String[] args) {
			int[] arr = {0,1,1,1,0,1,1,0,1};
			System.out.println(longestSubarray(arr));
		}
	}