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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        int a = DFS(root);
        return max;
    }
    
    
    public int DFS(TreeNode root)
    {
        if(root == null) return 0;
        int left = Math.max(0,DFS(root.left));
        int right = Math.max(0,DFS(root.right));
       
        max = Math.max(max, root.val + left + right);
        
        return Math.max(left, right) + root.val;
    }
}