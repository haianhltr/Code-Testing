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
        find(list,k, root, target, hash, 0);
        return list;
        
    }
    public void find(List<Integer> list, int k, TreeNode root, TreeNode target, HashMap<TreeNode, Integer> hash, int num)
    {
        if(root == null) return;
        if(hash.containsKey(root)) num = hash.get(root);
        if(num == k) 
        {
           list.add(root.val);
            
        }
        
        find(list, k , root.left, target, hash, num + 1);
        find(list, k , root.right, target, hash, num + 1);
        
    }
    
    
    public int DFS(TreeNode root, TreeNode target,HashMap<TreeNode, Integer> hash)
    {
        if(root == null) return -1;
        if(root.val == target.val) 
        {
            hash.put(root,0);
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
            hash.put(root, b + 1);
            return b + 1;
        }
        
        return -1;
    }
}