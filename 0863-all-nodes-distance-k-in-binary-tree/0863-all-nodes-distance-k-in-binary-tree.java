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
        fill(root, target, hash);
        DFS(list, root, hash, k, 0);
        return list;
        
    }
    
    public void DFS(List<Integer> list, TreeNode root, HashMap<TreeNode, Integer> hash, int k, int current)
    {
        if(root == null) return;
        if(hash.containsKey(root))
        {
            current = hash.get(root);
        }
        
        if(current == k) list.add(root.val);
        DFS(list, root.left, hash, k, current + 1);
        DFS(list, root.right, hash, k, current + 1);
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
        if(a >= 0)
        {
            hash.put(root, a + 1);
            return a + 1;
        }
        int b = fill(root.right, target, hash);
        if(b >= 0)
        {
            hash.put(root, b + 1);
            return b + 1;
        }
        
        return -1;
        
    }
}