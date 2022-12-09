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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return DFS(preorder, inorder, 0, preorder.length-1);
    }
    
    public TreeNode DFS(int [] pre, int [] in, int left, int right)
    {
        if(left > right) return null;
        int mid = left;
        for(int k = left; k <= right; k++)
        {
            if(in[k] == pre[index])
            {
                mid = k;
            }
        }
        
        TreeNode temp = new TreeNode(pre[index]);
        index++;
        temp.left = DFS(pre, in, left, mid -1);
        temp.right = DFS(pre,in, mid + 1, right);
        return temp;
    }
}