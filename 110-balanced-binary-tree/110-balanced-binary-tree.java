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
    private boolean check = true;
    public boolean isBalanced(TreeNode root) {
    DFS(root);
    return check;
    }
    
    private int DFS(TreeNode root)
    {
        if(root == null) return 0;
        int left = DFS(root.left);
        int right = DFS(root.right);
        if(Math.abs(left - right) > 1) check = false;
        return Math.max(left,right) + 1;
    }
}