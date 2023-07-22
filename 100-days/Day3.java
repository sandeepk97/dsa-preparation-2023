

// DAY 3
// Running Sum of 1d Array
class q1 {
    public int[] runningSum(int[] nums) {
        for (int i=1; i< nums.length;i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}

// Remove Element
class q2 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i=0; i < nums.length;i++) {
            if (nums[i] != val)
                nums[index++]=nums[i];
        }
        return index;
    }
}

// Find Winner on a Tic Tac Toe Game
class q3 {
    public String tictactoe(int[][] moves) {
        int[] rowCount = new int[3], columnCount = new int[3];
        int diagonal =0, antidagonal = 0, movesCount = 0;
        for (int[] move: moves) {
            boolean isFirst = movesCount%2==0;
            rowCount[move[0]] += isFirst ? 1:-1;
            columnCount[move[1]] += isFirst ? 1:-1;
            if (move[0] == move[1])
                diagonal += isFirst ? 1:-1;
            if (move[0] == 2-move[1])
                antidagonal += isFirst ? 1:-1;
            
            
            if (rowCount[move[0]] == 3 || columnCount[move[1]] == 3 || diagonal == 3 || antidagonal == 3)
                return "A";
            else if (rowCount[move[0]] == -3 || columnCount[move[1]] == -3 || diagonal == -3 || antidagonal == -3)
                return "B";
            movesCount++;
        }
        
        return movesCount == 9 ? "Draw": "Pending";
    }
}

// Build Array from Permutation
// #TODO

// Third Maximum Number
class q4 {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE,secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        for (int i=0; i< nums.length;i++) {
            if (firstMax == nums[i] || secondMax == nums[i] || thirdMax == nums[i])
                continue;
            
            if (firstMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (secondMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (thirdMax < nums[i]) {
                thirdMax = nums[i];
            }
        }
        return (int) (thirdMax == Long.MIN_VALUE ? firstMax: thirdMax);
    }
}


// Valid Mountain Array
class q5 {
    public boolean validMountainArray(int[] arr) {
        int i=0;
        while (i+1 < arr.length) {
            if (arr[i] == arr[i+1])
                return false;
            if (arr[i] > arr[i+1])
                break;
            i++;
        }
        
        if (i==0 || (i == arr.length - 1)) return false;
        
        while (i+1 < arr.length) {
            if (arr[i] == arr[i+1])
                return false;
            if (arr[i] < arr[i+1])
                break;
            i++;
        }
        
        return i == arr.length - 1; 
    }
}




public class Day3 {
	
}
