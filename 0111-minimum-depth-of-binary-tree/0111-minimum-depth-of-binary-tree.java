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
        int count = 0;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            count++;
            for(int k = 0; k < size; k++)
            {
                TreeNode temp = queue.poll();
                if(temp.left == null && temp.right == null) return count;
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                
           
            }
        }
        return count;
    }
}