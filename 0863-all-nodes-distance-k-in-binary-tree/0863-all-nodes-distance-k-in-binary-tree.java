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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList();
        if(k == 0)
        {
            list.add(target.val);
            
        }
        else{
            DFS(list, root, target, k,0);
        }
        
        return list;
    }
    public int DFS(List<Integer> list, TreeNode root, TreeNode target, int k, int depth)
    {
        //base case
        if(root == null) return 0;
        if(depth == k)
        {
            list.add(root.val);
            return 0;
        }
    
        int left,right;    
        //go left
        if(root.val == target.val || depth > 0)
        {
            left = DFS(list, root.left, target, k, depth + 1);
            right = DFS(list, root.right, target, k, depth + 1);
        }
        else
        {
            left = DFS(list, root.left, target, k, depth);
            right = DFS(list, root.right, target, k, depth);
        }
        
        
        if(root.val == target.val)
        {
            return 1;
        }
        
        if(left == k || right == k)
        {
            list.add(root.val);
            return 0;
        }
        //back to og
        if(left > 0)
        {
            DFS(list, root.right, target, k, left + 1);
            return left + 1;
        }
        if(right > 0)
        {
            DFS(list, root.left, target, k, right + 1);
            return right + 1;
        }
        
     
        
        //return statement
        return 0;
    }
}