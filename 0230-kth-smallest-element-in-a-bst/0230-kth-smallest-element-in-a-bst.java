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
    ArrayList<Integer> arr = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        arr = DFS(root);
        return arr.get(k-1);
    }
    
    public ArrayList<Integer> DFS(TreeNode root)
    {
        if(root == null) return null;
        ArrayList<Integer> temp = new ArrayList();
        temp.add(root.val);
        ArrayList<Integer> temp1 = DFS(root.left);
        if(temp1 != null)
        {
            temp.addAll(0, temp1);
        }
        ArrayList<Integer> temp2 = DFS(root.right);
        if(temp2 != null)
        temp.addAll(temp2);
        return temp;
        
    }
}