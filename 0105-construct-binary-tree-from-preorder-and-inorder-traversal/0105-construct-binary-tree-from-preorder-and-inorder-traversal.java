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
        return DFS(preorder, inorder, 0, inorder.length-1);
        
    }
    
    public TreeNode DFS(int [] pre, int [] in, int left, int right)
    {
        if(left > right)
        {
            return null;
        }
        
        //got 3
        int maxIndex = left;
        for(int k = left; k <= right; k++)
        {
            if(in[k] == pre[index])
            {
                maxIndex = k;
            }
            
        }
    
        
        TreeNode result = new TreeNode(pre[index]);
        index++;
        result.left = DFS(pre, in, left, maxIndex-1);
        result.right = DFS(pre, in, maxIndex + 1, right);
        
        return result;
    }
}