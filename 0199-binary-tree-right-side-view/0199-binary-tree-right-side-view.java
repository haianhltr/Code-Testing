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
        DFS(root, 0, list);
        return list;
    }
    
    public void DFS(TreeNode root, int pos, List<Integer> list)
    {
        if(root == null) return;
        if(pos == list.size()) list.add(root.val);
        DFS(root.right, pos + 1, list);
        DFS(root.left, pos + 1, list);
    }
}