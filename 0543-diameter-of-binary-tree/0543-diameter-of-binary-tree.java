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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       DFS(root);
        return max;
    }
    
    public int DFS(TreeNode root)
    {
        if(root == null) return 0;
        int a = DFS(root.left);
        int b = DFS(root.right);
        max = Math.max(max, a +b );
        return Math.max(a,b) + 1;
    }
}