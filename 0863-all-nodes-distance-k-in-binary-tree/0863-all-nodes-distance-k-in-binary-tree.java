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
        else DFS(root, target, k, 0, list);
        return list;
    }
    
    public int DFS(TreeNode root, TreeNode target, int k, int depth, List<Integer> list)
    {
        if(root == null) return 0;
        if(depth == k)
        {
            list.add(root.val);
            return 0;
        }
            
        int a, b;
        if(root.val == target.val || depth > 0) 
        {
           a = DFS(root.left, target, k , depth+1, list);
           b= DFS(root.right, target, k, depth + 1, list);
            
        }
        else
        {
          a = DFS(root.left, target, k , depth, list);
          b = DFS(root.right, target, k, depth, list);
        }
        
        if(root.val == target.val)
        {
            return 1;
        }
        
        if(a == k || b == k)
        {
            list.add(root.val);
            return 0;
        }
        
        if(a > 0)
        {
            DFS(root.right, target, k, a + 1, list);
            return a + 1;
        }
        if(b > 0)
        {
            DFS(root.left, target, k, b + 1, list);
            return b + 1;
        }
        
        return 0;
        
        
    }
}