
// 	DAY 8

import java.util.LinkedList;
import java.util.Queue;


public class Day8 {
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
	// Subtree of Another Tree
	// TODO: other approaches
    public boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        else if (root != null && subRoot != null)
            return root.val == subRoot.val && isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
        else
            return false;
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == subRoot.val && isEqual(curr, subRoot))
                return true;
            if (curr.left != null)
                q.add(curr.left);
             if (curr.right != null)
                q.add(curr.right);   
        }
        return false;
    }
}

// Diameter of Binary Tree


// Balanced Binary Tree


// Merge Two Binary Trees
class q4 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}

// Same Tree
class q5 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p!=null && q!=null)
            return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        if (p==null && q==null)
            return true;
        return false;
    }
}
}
