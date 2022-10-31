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
        DFS(root, targetSum, list, temp);
        return list;
    }
    public void DFS(TreeNode root, int targetSum, List<List<Integer>> list, List<Integer>temp)
    {
        if(root == null) return;
        temp.add(root.val);
        if(root.left == null && root.right == null && targetSum - root.val == 0) list.add(new ArrayList(temp));
        DFS(root.left, targetSum-root.val, list, temp);
        DFS(root.right, targetSum-root.val, list, temp);
        temp.remove(temp.size()-1);
    }
}