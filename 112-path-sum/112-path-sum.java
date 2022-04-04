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
    boolean check = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
    checkT(root,targetSum);
       return check;
    }
    private void checkT(TreeNode root, int sum)
    {
        if(root == null) return;
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) check = true;
      
        checkT(root.left,sum);
        checkT(root.right,sum);
    }
    
}