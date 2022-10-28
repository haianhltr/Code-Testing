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
        ArrayList<Integer> list = new ArrayList();
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap();
        fill(root, hash);
        Set<Integer> set = new HashSet();
        Queue<Integer> queue  = new LinkedList();
        queue.add(target.val);
        while(k >0)
        {
            int size = queue.size();
             k--;
            for(int i = 0; i < size; i++)
                {
                
                    int temp = queue.poll();
                    set.add(temp);
                    for(int a : hash.get(temp))
                    {
                        if(!set.contains(a))
                        {
                           queue.add(a);  
                        }
                      
                       
                    }
                }
              
        }
        
        while(!queue.isEmpty())
        {
            list.add(queue.poll());
        }
        return list;
    }
    
    public void fill(TreeNode root, HashMap<Integer, ArrayList<Integer>> hash)
    {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        hash.put(root.val, new ArrayList<Integer>());
        while(!queue.isEmpty())
        {
            int size = queue.size();
           
            for(int k = 0; k < size; k++)
            {
                TreeNode temp = queue.poll();
                if(!hash.containsKey(temp.val))
                hash.put(temp.val, new ArrayList<Integer>());
                if(temp.left != null)
                {
                    hash.get(temp.val).add(temp.left.val);
                    hash.put(temp.left.val, new ArrayList<Integer>());
                    hash.get(temp.left.val).add(temp.val);
                    queue.add(temp.left);
                    
                }
                if(temp.right != null)
                {
                    hash.get(temp.val).add(temp.right.val);
                    hash.put(temp.right.val, new ArrayList<Integer>());
                    hash.get(temp.right.val).add(temp.val);
                    queue.add(temp.right);
                }
            }
        }
    }
}