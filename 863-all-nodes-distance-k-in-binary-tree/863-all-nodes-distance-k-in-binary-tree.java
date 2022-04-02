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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int edge) {
        List<Integer> list = new ArrayList();
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        Map<TreeNode, List<TreeNode>> hash = new HashMap();
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int k =0; k < size ;k++)
            {
                TreeNode temp = queue.poll();
                if(!hash.containsKey(temp)) hash.put(temp, new ArrayList<TreeNode>());
                if(temp.left != null)
                {
                    queue.add(temp.left);
                    hash.put(temp.left, new ArrayList<TreeNode>());
                    hash.get(temp).add(temp.left);
                    hash.get(temp.left).add(temp);
                }
                
                if(temp.right != null)
                {
                    queue.add(temp.right);
                    hash.put(temp.right, new ArrayList<TreeNode>());
                    hash.get(temp).add(temp.right);
                    hash.get(temp.right).add(temp);
                }
            }
        }
        
        
        Set<TreeNode> been = new HashSet();
        queue.add(target);
         while(edge > 0 && !queue.isEmpty())
         {
                edge--;
                int size = queue.size();
                for(int k = 0; k < size ;k++)
                {
                TreeNode temp = queue.poll();
                been.add(temp);
                System.out.println(temp.val);
                for(TreeNode t : hash.get(temp))
                {
                    if(!been.contains(t))
                    {
                        queue.add(t);
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
}