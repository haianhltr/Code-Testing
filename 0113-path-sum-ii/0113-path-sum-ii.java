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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList();
         List<Integer> temp = new ArrayList();
        DFS(root, targetSum, temp, list);
        return list;
    }
    
    public void DFS(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> list)
    {
        
        if(root == null) return;
        temp.add(root.val);
      
        if(root.left == null && root.right == null && targetSum - root.val == 0) 
        {
           list.add(new ArrayList(temp)); 
           temp.remove(temp.size()-1);
            return;
        }
            
        DFS(root.left, targetSum - root.val, temp, list);
        DFS(root.right, targetSum - root.val, temp, list);
        temp.remove(temp.size()-1);
            
    }
}