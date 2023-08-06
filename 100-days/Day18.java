
// 	DAY 18

import java.util.HashMap;
import java.util.Map;

public class Day18 {
	
// Word Pattern
// Number of Good Pairs
class q2 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        int count = 0;
        for (int val: hm.values()) {
            count += val*(val-1)/2;
        }
        return count;
    }

	 public int numIdenticalPairs1Pass(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
		
		int count = 0;
        for (int i=0; i<nums.length; i++) {
			count += hm.getOrDefault(nums[i], 0);
            hm.put(nums[i], count + 1);
        }
        return count;
    }
}


// Flood Fill
// Island Perimeter
// Find if Path Exists in Graph
}
