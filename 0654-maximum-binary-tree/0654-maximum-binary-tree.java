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
    
    public TreeNode DFS(int [] nums, int start, int end)
    {
        if(start > end) return null;

        int max = start;
        for(int k = start + 1; k <= end; k++)
        {
            if(nums[k] > nums[max])
            {
                max = k;
              
            }
        }
        
        
        TreeNode temp = new TreeNode(nums[max]);
        temp.left = DFS(nums, start, max-1);
        temp.right = DFS(nums, max+1, end);
        return temp;
    }
}