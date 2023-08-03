
public class Day16 {
// 	DAY 16
// Binary Search
class q1 {
    public int search(int[] nums, int target) {
        int i=0, j= nums.length-1, mid;
        while (i<=j) {
            mid = i+(j-i)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        
        return i < nums.length && nums[i] == target ? i:-1;
    }
}

// Search Insert Position


// First Bad Version
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
	  class VersionControl {
		boolean isBadVersion(int version) {
			return false;
		}
	  }

	class q3 extends VersionControl {
		public int firstBadVersion(int n) {
			int low = 1, high = n;
			while (low< high) {
				int mid = low + (high-low)/2;
				if (isBadVersion(mid)) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}
			return low;
		}
	}
// Valid Perfect Square
class q4 {
    public boolean isPerfectSquare(int num) {
        long i=1, j = num;
        while (i <= j) {
            long mid = i+(j-i)/2;
            if (mid*mid == num) {
                return true;
            } else if  (mid*mid > num) {
                j = mid -1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}

// Kth Missing Positive Number


// Kth Largest Element in a Stream
}
