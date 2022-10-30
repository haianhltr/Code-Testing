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
        DFS(root, list , 0);
        return list;
    }
    public void DFS(TreeNode root, List<Integer> list, int depth)
    {
        if(root == null) return;
        if(list.size() == depth) list.add(root.val);
        DFS(root.right, list, depth + 1);
        DFS(root.left, list, depth + 1);
    }
}