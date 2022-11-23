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
    public int widthOfBinaryTree(TreeNode root) {
        return DFS(root, new ArrayList<Integer>(), new ArrayList<Integer>(), 0 , 1);
        
    }
    
    public int DFS(TreeNode root, List<Integer> start, List<Integer> end, int level , int width)
    {
        if(root == null) return 0;
        
        //go to each level, if revert back and has something on the right, replace that number with the width
        
        if(level == start.size())
        {
            start.add(width);
            end.add(width);
        }
        else
        {
            end.set(level, width);
        }
        
        int cur = end.get(level) - start.get(level) + 1;
        
        int left = DFS(root.left, start, end, level + 1, 2 * width);
        int right = DFS(root.right, start, end, level + 1, 2 * width + 1);
        
        return Math.max(cur, Math.max(left, right));
    }
}