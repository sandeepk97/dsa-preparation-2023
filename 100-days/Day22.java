public class Day22 {
// 	DAY 22
// Container With Most Water
class q1 {
    // https://leetcode.com/problems/container-with-most-water/solutions/
    // We starts with the widest container, l = 0 and r = n - 1. Let's say the left one is shorter: h[l] < h[r]. Then, this is already the largest container the left one can possibly form. There's no need to consider it again. Therefore, we just throw it away and start again with l = 1 and r = n -1.
    public int maxArea(int[] height) {
       int i=0, j= height.length -1, maxArea = Math.min(height[0], height[height.length-1]) * Math.abs(height.length-1);
        
        while (i < j) {
            if (height[i] < height[j]) {
                i++;
            } else
                j--;
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * Math.abs(j-i));
        }
        return maxArea;
    }
}
// Sort Colors
// Rotate Array
// Contiguous Array
}
