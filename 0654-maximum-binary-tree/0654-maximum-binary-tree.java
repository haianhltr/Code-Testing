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
        return DFS(nums, 0, nums.length - 1);
        
    }
    
    public TreeNode DFS(int [] nums, int left, int right)
    {
        if(left > right) return null;
        int mid = left;
        int max = nums[mid];
        for(int k = left; k <= right; k++)
        {
            if(nums[k] > max) 
            {
                mid = k;
                max = nums[k];
            }
        }
        TreeNode temp = new TreeNode(max);
        temp.left = DFS(nums, left, mid - 1);
        temp.right = DFS(nums, mid + 1, right );
        return temp;
    }
}