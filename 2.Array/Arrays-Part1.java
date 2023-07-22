// Array Assignment Part 1 

// 1. https://leetcode.com/problems/two-sum/ 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0; i< nums.length;i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[] {(int) map.get(target-nums[i]), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {};
    }
}

// 2. https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class q2 {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0, j = nums.length-1; i<j;) {
            if(nums[i] + nums[j] > target)
                j--;
            else if (nums[i] + nums[j] < target)
                i++;
            else 
                return new int[]{i+1, j+1};
        }
        return new int[0];
    }
}

//  3. https://leetcode.com/problems/merge-sorted-array/ 
class q3 {
	// space O(1)
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int len = nums1.length -1;
	
		int i = m-1, j = n-1;
		while(i>=0 && j>=0 && i < m && j < n){
			
			if(nums1[i] >= nums2[j]){
				nums1[len--] = nums1[i--];
			}else{
				nums1[len--] = nums2[j--];
			}
		}
		
		while(i>=0 && i< m){
			nums1[len--] = nums1[i--];
		}
		
		while(j>=0 && j< n){
			nums1[len--] = nums2[j--];
		}
		return;
	}
}

// 4. https://leetcode.com/problems/pascals-triangle/ 

class q4 {
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }
}

// 5. https://leetcode.com/problems/pascals-triangle-ii/ 

class q5 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0; i <= rowIndex; i++) {
            result.add( 1);
            for (int j=i-1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j-1));
            }
        }
        return result;
    }
}

// 6. https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class q6 {
    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int buyMin = prices[0];
        int profit = 0;
        for (int i=1; i< prices.length; i++) {
            profit = Math.max(profit, prices[i] - buyMin);
            
            if (prices[i] < buyMin) buyMin = prices[i];
        }
        return profit;
    }
}

//  7. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class q7 {
    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int profit = 0;
        for (int i=1; i< prices.length; i++) {
            if (prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}

//  8. https://leetcode.com/problems/majority-element/
class q8 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num: nums) {
            if (count == 0)
                candidate = num;
            
            count += (candidate == num) ? 1: -1;
        }
        return candidate;
    }
}

//  9. https://leetcode.com/problems/majority-element-ii/

//  10.https://leetcode.com/problems/missing-ranges/ 

class q10 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            addRange(ans, lower, upper);
            return ans;
        }

        addRange(ans, lower, (long)nums[0] - 1);

        for (int i = 1; i < nums.length; i++) {
            addRange(ans, (long)nums[i - 1] + 1, (long)nums[i] - 1);
        }
        addRange(ans, (long)nums[nums.length - 1] + 1, upper);

        return ans;
    }

    void addRange(List<String> ans, long st, long ed) {
        if (st > ed) {
            return;
        }
        if (st == ed) {
            ans.add(st + "");
            return;
        }
        ans.add(st + "->" + ed);
    }

}

// 11.https://leetcode.com/problems/3sum/ 
class q11 {
    public List<List<Integer>> threeSum(int[] nums) {
		// List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<>();
		for (int i=0; i < nums.length - 2; i++) {
			int target = -nums[i];
			for (int j=i+1, z=nums.length-1; j<nums.length && j<z;) {
				if (nums[j] + nums[z] == target) {
					result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j++], nums[z--])));
				} else if (nums[j] + nums[z] > target) {
					z--;
				} else {
					j++;
				}
			}
		}
		return new ArrayList<>(result);
	}
}

// 12.https://leetcode.com/problems/3sum-smaller/ 

class q12 {
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int count = 0;
        for (int i=0; i < nums.length; i++) {
            int sum = target - nums[i];
            for (int j=i+1, k= nums.length-1; j<nums.length && j<k;) {
                if (nums[j] + nums[k] < sum) {
                    count += k-j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}

// 13.https://leetcode.com/problems/3sum-closest/ 

class q13 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, m = Integer.MAX_VALUE;
        for (int i=0; i<nums.length-2; i++) {
            for (int j=i+1, k=nums.length-1; j < nums.length && j<k;) {
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < m) {
                    m = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    sum = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
                
            }
        }
        return sum;
    }
}

// 14.https://leetcode.com/problems/4sum/




// 15.https://leetcode.com/problems/rotate-image/
