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
        HashMap<TreeNode, ArrayList<TreeNode>> hash = new HashMap();
        List<Integer> list = new ArrayList();
        Set<TreeNode> set = new HashSet();
        Queue<TreeNode> queue = new LinkedList();
        fill(root, hash,queue);
        
        
        queue.add(target);
        while(k > 0)
        {
            int size = queue.size();
            k--;
            for(int i = 0; i < size; i++)
            {
                TreeNode temp  = queue.poll();
                
                set.add(temp);
                for(TreeNode member : hash.get(temp))
                {
                    if(!set.contains(member))
                    {
                        queue.add(member);
                      
                    }
                    
                }
            }
        }
        
        while(!queue.isEmpty())
        {
            list.add(queue.poll().val);
        }
        
        return list;
        
    }
    
    public void fill(TreeNode root, HashMap<TreeNode, ArrayList<TreeNode>> hash, Queue<TreeNode> queue)
    {
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int k = 0; k < size; k++)
            {
                TreeNode temp = queue.poll();
                if(!hash.containsKey(temp))
                {
                    hash.put(temp, new ArrayList());
                }
                if(temp.left != null)
                {
                    hash.get(temp).add(temp.left);
                    hash.put(temp.left, new ArrayList());
                    hash.get(temp.left).add(temp);
                    queue.add(temp.left);
                }
                if(temp.right != null)
                {
                    hash.get(temp).add(temp.right);
                    hash.put(temp.right, new ArrayList());
                    hash.get(temp.right).add(temp);
                    queue.add(temp.right);
                    
                }
            }
        }
    }
}