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
    public boolean check = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        DFS(root,targetSum);
            return check;
    }
    private void DFS(TreeNode root, int sum)
    {
        if(root == null) return;
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) check = true;
        DFS(root.left,sum);
        DFS(root.right,sum);
    }
}