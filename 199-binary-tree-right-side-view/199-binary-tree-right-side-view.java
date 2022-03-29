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
    public List<Integer> rightSideView(TreeNode root) {
  
        List<Integer> list = new ArrayList();
             if(root == null) return list;
     
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int k = 0; k < size; k++)
            {
                TreeNode temp = queue.poll();
                if(temp.right != null) queue.add(temp.right);
                if(temp.left != null)queue.add(temp.left);
                if(k==0)list.add(temp.val);
            }
        }
        return list;
    }
}


 