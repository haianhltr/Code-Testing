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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        int depth = 0;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            depth++;
            for(int k = 0; k < size; k++)
            {
                TreeNode current = queue.poll();
                if(current.left == null && current.right == null) return depth;
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                
            }
        }
        return depth;
    }
}