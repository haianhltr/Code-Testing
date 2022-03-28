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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        
        while(!queue.isEmpty())
        {
            double total = 0;
            int size = queue.size();
            for(int k = 0; k < size; k++)
            {
                  TreeNode temp = queue.poll();
                  total += temp.val;
                  if(temp.left != null) queue.add(temp.left);
                  if(temp.right != null) queue.add(temp.right);
                
            }
            list.add(total/size);
        }
        
        return list;
    }
}