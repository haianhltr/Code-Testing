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
    int pos = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return DFS(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode DFS(int [] preorder, int [] inorder, int left, int right)
    {
        if(left > right) return null;
        int maxIndex = left;        
        for(int k = left + 1; k <= right; k++)
        {
            if(inorder[k] == preorder[pos])
            {
                maxIndex = k;
            }
        }
        
        
        TreeNode temp = new TreeNode(preorder[pos]);
        pos ++;
        temp.left = DFS(preorder, inorder, left, maxIndex -1);
        temp.right = DFS(preorder, inorder, maxIndex + 1, right);
        return temp;
    }
}