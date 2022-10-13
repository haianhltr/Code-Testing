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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int k = 0; k < size; k++)
            {
                TreeNode current = queue.poll();
                if(current.val == subRoot.val)
                {
                    if(check(current, subRoot) == true)
                    {
                        return true;
                    }
                }
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                
            }
        }
        return false;
     
    }
    
    
    public boolean check(TreeNode p, TreeNode q)
    {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return check(p.left, q.left) && check(p.right, q.right);
    }
    
}