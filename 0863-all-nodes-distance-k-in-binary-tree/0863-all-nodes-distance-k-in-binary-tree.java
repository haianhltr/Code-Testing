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
        HashMap<TreeNode, Integer> hash = new HashMap();
        List<Integer> list = new ArrayList();
        DFS(root, target, hash);
        find(hash, list, root, target, k, 0);
        return list;
        
    }
    
    public void find(HashMap<TreeNode, Integer> hash, List<Integer> list, TreeNode root, TreeNode target, int k, int length)
    {
        if(root == null) return;
       
        if(hash.containsKey(root)) length = hash.get(root);
         if(k == length)
        {
          list.add(root.val);
           
        }
        find(hash, list, root.left, target, k, length + 1);
        find(hash, list,root.right, target, k, length + 1);
    }
    
    public int DFS(TreeNode root, TreeNode target, HashMap<TreeNode, Integer> hash)
    {
        if(root == null) return -1;
        if(root.val == target.val)
        {
            hash.put(root, 0);
            return 0;
        }
        
        int left = DFS(root.left, target, hash);
        if(left >= 0)
        {
            hash.put(root, left + 1);
            return left + 1;
        }
        int right = DFS(root.right, target, hash);
        if(right >= 0)
        {
            hash.put(root, right + 1);
            return right + 1;
        }
        
        return -1;
        
    }
}