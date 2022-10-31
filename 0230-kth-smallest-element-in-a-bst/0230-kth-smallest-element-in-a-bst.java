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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        DFS(list, root);
        return list.get(k-1);
    }
    
    public void DFS(List<Integer> list, TreeNode root)
    {
        if(root == null) return;
        DFS(list, root.left);
        list.add(root.val);
        DFS(list, root.right);
    }
}