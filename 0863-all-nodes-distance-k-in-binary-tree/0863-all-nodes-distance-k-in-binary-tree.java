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
        fill(hash,target,root);
        if(k == 0)
        {
            list.add(target.val);
        }
        else
        {
            DFS(list, hash, root, k, 0);
        }
        
        return list;
    }
    
    public void DFS(List<Integer> list, HashMap<TreeNode, Integer> hash, TreeNode root, int k, int length)
    {
        if(root == null) return;
        if(hash.containsKey(root)) 
        {
            length = hash.get(root);
        }
        if(length == k) list.add(root.val);
        DFS(list, hash, root.left, k, length+1);
        DFS(list, hash, root.right, k, length+1);
    }
    
    public int fill(HashMap<TreeNode, Integer> hash, TreeNode target, TreeNode root)
    {
        if(root == null) return -1;
        if(root.val == target.val)
        {
            hash.put(root, 0);
            return 0;
        }
        int left = fill(hash, target, root.left);
        if(left >= 0)
        {
            hash.put(root, left + 1);
            return(left +1);
        }
        int right = fill(hash,target, root.right);
        if(right >= 0)
        {
            hash.put(root, right  +1);
            return(right +1);
        }
        
        return -1;
    }
}