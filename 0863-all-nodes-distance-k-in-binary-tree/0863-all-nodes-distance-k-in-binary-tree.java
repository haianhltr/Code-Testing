/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
        List<Integer> list = new ArrayList();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0)
        {
            list.add(target.val);
            return list;
        }
        else
        { DFS(root, target, k, 0);
        return list;
        }
    }
    public int DFS(TreeNode root, TreeNode target, int k , int length)
    {
        if(root == null) return 0;
        if(length == k) 
        {
            list.add(root.val);
            return 0;
        }
        int left, right =0;
        if(root.val == target.val || length > 0)
        {
            left= DFS(root.left, target, k, length + 1);
            right = DFS(root.right, target, k, length + 1);
        }
        else
        {
            left= DFS(root.left, target, k, length);
            right =DFS(root.right, target, k, length);
        }
    
        if(root.val == target.val)
        {
            return 1;
        }
        
        if(left == k || right == k)
        {
            list.add(root.val);
        }
        
        if(left > 0)
        {
            DFS(root.right, target, k, left + 1);
            return left + 1;
        }
        
        if(right > 0)
        {
            DFS(root.left, target, k, right + 1);
            return right + 1;
        }
        
        return 0;
        
        
    }
}