 class StackPart1 {
// 	https://leetcode.com/problems/trapping-rain-water/
class q1 {
	// TODO using stack
    public int trap(int[] height) {
        int[] l = new int[height.length];
        int[] r = new int[height.length];
        l[0] = 0;
        r[height.length-1] = 0;
        for (int i=1; i<height.length-1; i++) {
            l[i] = Math.max(height[i-1], l[i-1]);
            r[height.length-i-1] = Math.max(height[height.length-i], r[height.length-i]);
        }

        int area = 0;
        for (int i=0; i < height.length; i++) {
            int curr = Math.min(l[i], r[i]) - height[i];
            if (curr > 0)
                area += curr;
        }
        return area;
    }
}


// https://leetcode.com/problems/valid-parentheses/

// https://leetcode.com/problems/decode-string/

// https://leetcode.com/problems/min-stack/

// https://leetcode.com/problems/baseball-game/

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

// https://leetcode.com/problems/implement-stack-using-queues/

// https://leetcode.com/problems/make-the-string-great/

// https://leetcode.com/problems/backspace-string-compare/

// https://leetcode.com/problems/largest-rectangle-in-histogram/
}
