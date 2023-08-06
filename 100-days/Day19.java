// 	DAY 19

import java.util.Arrays;

public class Day19 {
// Fibonacci Number
class q1 {
    public int fib(int n) {
        if (n<=1) return n;
        int first = 0, second = 1, result = 0;
        for (int i=2; i<=n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }


	public int recur_fib(int n) {
        if (n<2) return n;
        return recur_fib(n-1) + recur_fib(n-2);
    }
}


// Min Cost Climbing Stairs
// Climbing Stairs
// TODO: UNDERSTAND VISUALS
class q3 {
    public int climbStairs(int n) {
        if (n<=3) return n;
        int first = 1, second = 2, result = 0;
        for (int i=2; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
// Pascal's Triangle
// Can Place Flowers
// Maximum Units on a Truck
// todo check efficiency
class q5 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        
        int maxUnits = 0, totalNoOfBoxes = 0, i=0;
        while (totalNoOfBoxes < truckSize && i < boxTypes.length) {
            if (totalNoOfBoxes + boxTypes[i][0] > truckSize) {
                maxUnits += (truckSize-totalNoOfBoxes) * boxTypes[i][1];
                totalNoOfBoxes += (truckSize-totalNoOfBoxes) * boxTypes[i][1];
            } else {
                maxUnits += boxTypes[i][0] * boxTypes[i][1];
                totalNoOfBoxes += boxTypes[i][0];
            }
            i++;
        }
        
        return maxUnits;
    }
}
}
