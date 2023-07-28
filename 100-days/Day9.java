// DAY 9

import java.util.ArrayList;
import java.util.List;

public class Day9 {
/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

// Path Sum
class q1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, root.val, targetSum);
    }
    
    public boolean dfs(TreeNode root, int currSum, int targetSum) {
        if (root.left == null && root.right == null && currSum == targetSum) { return true; }

        boolean isLeft = false;
        if (root.left != null)
            isLeft = dfs(root.left, currSum + root.left.val, targetSum);
        
        boolean isRight = false;
        if (root.right != null)
            isRight = dfs(root.right, currSum + root.right.val, targetSum);
        
        return isLeft || isRight;
    }
}

// Binary Tree Paths
class q2 {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "" + root.val, result);
        return result;
    }
    
    public void dfs(TreeNode root, String curr, List<String> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(curr);
            return;
        } 
        
        if (root.left != null) {
            dfs(root.left, curr + "->" + root.left.val, result);
        }
        
        if (root.right != null) {
            dfs(root.right, curr + "->" + root.right.val, result);
        }
        
    }
}

// Cousins in Binary Tree
class q3 {
    int depthX = -1, depthY = -1, parentX = -1, parentY = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        bfs(root, x,y, 0, 0);
        return depthX != -1 && parentX !=-1 &&  parentX != parentY && depthX == depthY;
    }
    
    
    public void bfs(TreeNode root, int x, int y, int depth, int parent) {
        if (root == null) return;
        if (root.val == x) { depthX = depth; parentX = parent; return; }
        else if (root.val == y) { depthY = depth; parentY = parent;  return; }
        bfs(root.left, x,y,depth+1, root.val);
        bfs(root.right, x,y,depth+1, root.val);
    }  
    
}

// Convert Sorted Array to Binary Search Tree


// Range Sum of BST	


}
