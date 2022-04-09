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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue =new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            TreeNode tempo = new TreeNode(0);
            tempo = temp.left;
            temp.left = temp.right;
            temp.right = tempo;
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
            
        }
        
        return root;
    }
}