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
        HashMap<TreeNode, List<TreeNode>> hash = new HashMap();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
                while(size --> 0)
                {
                    TreeNode current = queue.poll();
                    if(!hash.containsKey(current)) hash.put(current, new ArrayList<TreeNode>());
                    if(current.left != null) 
                    {
                        hash.put(current.left, new ArrayList<TreeNode>());
                        hash.get(current.left).add(current);
                        queue.add(current.left);
                        hash.get(current).add(current.left);
                    }
                    if(current.right != null) 
                    {
                        
                        hash.put(current.right, new ArrayList<TreeNode>());
                        hash.get(current.right).add(current);
                        queue.add(current.right);
                        hash.get(current).add(current.right);
                    }
                    
                }
            
        }
        
    
       Set<TreeNode> seen = new HashSet();
        queue.add(target);
        
        while(k >0)
        {
            int size = queue.size();
            k--;
            for(int j = 0; j < size; j++)
            {
                    TreeNode current = queue.poll();
                    seen.add(current);
                    for(TreeNode b : hash.get(current))
                    {
                    if(!seen.contains(b))
                    {
                        queue.add(b);
                    }
                       
                    }

                    
            }
        }
        
        while(!queue.isEmpty()){
           list.add(queue.poll().val);
        }
       
        
        return list;
    }
}