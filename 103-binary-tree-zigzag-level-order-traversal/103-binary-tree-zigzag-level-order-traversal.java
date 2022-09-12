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
        boolean flip = true;
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> tempList = new ArrayList();
            while(size-->0)
            {
                TreeNode current = queue.poll();
                if(flip == true)
                {
                         tempList.add(current.val);
                }
                else
                {
                    tempList.add(0, current.val);
                }
           
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            flip = !flip;
            list.add(tempList);
        }
        return list;
        
    }
}