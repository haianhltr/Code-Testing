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
        HashMap<TreeNode, Integer> hash = new HashMap();
        DFS(root, target, hash);
        fill(list, root, target, hash, k, 0);
        return list;
    }
    
    public void fill(List<Integer> list, TreeNode root, TreeNode target, HashMap<TreeNode, Integer> hash, int k, int length)
    {
       if(root == null) return;
        if(hash.containsKey(root))
        {
         length = hash.get(root);
     
        }
         if(length == k) 
         {
             list.add(root.val);
    
         }
        fill(list, root.left, target, hash, k, length + 1);
        fill(list, root.right, target, hash, k, length + 1);
    }
    
    public int DFS(TreeNode root, TreeNode target, HashMap<TreeNode, Integer> hash)
    {
        if(root == null) return -1;
        if(root.val == target.val)
        {
            hash.put(root, 0);
            return 0;
        }
        
        int a = DFS(root.left, target, hash);
        if(a >= 0)
        {
            hash.put(root, a + 1);
            return a + 1;
        }
        
        int b = DFS(root.right, target, hash);
        if(b >= 0)
        {
            hash.put(root, b + 1) ;
            return b + 1;
        }
        
        return -1;
            
            
            
    }
}