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
    int num = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      DFS(root);
        return num;
    }
    
    public int DFS(TreeNode root)
    {
        if(root == null) return 0;
        int a = Math.max(0, DFS(root.left));
        int b = Math.max(0, DFS(root.right));
        num = Math.max(num, root.val + a + b);
        return Math.max(a,b) + root.val;
    }
}