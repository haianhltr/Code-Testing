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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer> tempList = new ArrayList();
            int size = queue.size();
            for(int k = 0; k  <size ; k++)
            {
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                tempList.add(temp.val);
            }
            list.add(tempList);
        }
        return list;
        
    }
}