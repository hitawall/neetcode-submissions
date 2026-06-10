/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        return isValidBST(root.left, Integer.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int lowBound, int highBound)
    {
        if(root==null)
            return true;
        
        if(root.val>lowBound && root.val<highBound)
        {
            return isValidBST(root.left, lowBound, root.val) && isValidBST(root.right, root.val, highBound);
        }

        return false;
    }
}
