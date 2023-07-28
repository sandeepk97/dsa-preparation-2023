
// DAY 7

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Day7 {

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
 
class q1 {
	// Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) return result;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            result.add(curr.val);
            if (curr.right != null)
                s.push(curr.right);
            if (curr.left != null)
                s.push(curr.left);
        }
        
        return result;
        
        
        // List<Integer> result = new ArrayList<>();
        // preorderTraversal(root, result);
        // return result;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}

// Binary Tree Inorder Traversal
class q2 {
	// TODO recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}

// Binary Tree Postorder Traversal
class q3 {
	// TODO recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }
    
    public void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}

// Maximum Depth of Binary Tree
class q4 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}


// Invert Binary Tree
class q5 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    
    
    public void invert(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }
}

// Symmetric Tree
class q6 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right!= null) 
            return (left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));

        return false;        
    }
}
}
