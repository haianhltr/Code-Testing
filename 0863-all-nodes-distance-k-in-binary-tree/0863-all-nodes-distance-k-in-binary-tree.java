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
        fill(root, target, hash);
        find(root, hash, k, 0, list);
        return list;
    }
    
    public void find(TreeNode root, HashMap<TreeNode, Integer> hash, int k, int current, List<Integer> list)
    {
        if(root == null) return;
        if(hash.containsKey(root)) current = hash.get(root);
        if(k == current)
        {
            list.add(root.val);
    
        }
        find(root.left, hash, k, current+1, list);
        find(root.right, hash, k , current+1,list);
    }
    
    public int fill(TreeNode root, TreeNode target, HashMap<TreeNode, Integer> hash)
    {
        if(root == null) return -1;
        if(root.val == target.val)
        {
            hash.put(root, 0);
            return 0;
        }
        
        int a = fill(root.left, target, hash);
        int b = fill(root.right, target, hash);
        
        if(a >= 0)
        {
            hash.put(root, a + 1); 
            return a+1;
        }
        if(b >= 0)
        {hash.put(root, b + 1);
            return b+1;}
        
        return -1;
        
      
    }
}