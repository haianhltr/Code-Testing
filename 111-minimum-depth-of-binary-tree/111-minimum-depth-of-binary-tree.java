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
        Queue<TreeNode> queue = new LinkedList();
        if(root == null) return 0;
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty())
        {
            level++;
            int size = queue.size();
            for(int k =0; k < size; k++)
            {
                TreeNode current = queue.poll();
                if(current.left == null && current.right == null) return level;
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                
            }
            
            
        }
        return level;
    }
}