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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
           List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean check = false;
        while(!queue.isEmpty())
        {
            List<Integer> tempList = new ArrayList();
            int size = queue.size();
            for(int k = 0; k  <size ; k++)
            {
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                
                if(check)
                {
                tempList.add(0,temp.val);
                }
                else{
                    tempList.add(temp.val);
                    
                }
               
            }
             check  = !check;
            list.add(tempList);
        }
        return list;
        
    }
}