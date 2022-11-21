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
        DFS(root, targetSum, new ArrayList(), list);
        return list;
    }
    public void DFS(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result)
    {
       
        if(root == null) return;
          list.add(root.val);
        if(root.left == null && root.right == null && targetSum - root.val == 0)
        {
           
            result.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
 
        DFS(root.left, targetSum - root.val, list, result);
        DFS(root.right, targetSum - root.val, list, result);
        list.remove(list.size()-1);
        
    }
}