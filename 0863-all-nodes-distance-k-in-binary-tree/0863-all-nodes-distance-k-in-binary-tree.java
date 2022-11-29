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
        check(root, list, hash, 0, k);
        return list;
    }
    public void check(TreeNode root, List<Integer> list, HashMap<TreeNode, Integer> hash, int pos, int k)
    {
        if(root == null) return;
    
        if(hash.containsKey(root)) pos = hash.get(root);
            if(pos == k)
        {
            list.add(root.val);
           
        }
        check(root.left, list, hash, pos + 1, k);
        check(root.right, list, hash, pos +1, k);
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
            hash.put(root, b + 1);
            return b + 1;
        }
        
        return -1;
    }
}