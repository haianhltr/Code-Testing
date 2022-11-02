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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return DFS(nums, 0, nums.length-1);
    }
    
    public TreeNode DFS(int [] nums, int left, int right)
    {
  
        if(left > right) return null;
        int maxIndex = left;
        for(int k = left+1; k <= right; k++)
        {
            if(nums[k] > nums[maxIndex])
            {
                maxIndex = k;
            }
        }
        
        TreeNode result = new TreeNode(nums[maxIndex]);
        result.left = DFS(nums, left, maxIndex-1);
        result.right = DFS(nums, maxIndex + 1, right);
        
        return result;
    }
}