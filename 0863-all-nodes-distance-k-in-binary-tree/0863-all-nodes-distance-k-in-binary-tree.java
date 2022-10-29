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
        HashMap<TreeNode, ArrayList<TreeNode>> hash = new HashMap();
        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> set = new HashSet();
        fill(hash, queue, root);
        find(hash, list, set ,queue, target, k);
        return list;
            
    }
    
    public void find(HashMap<TreeNode, ArrayList<TreeNode>> hash, List<Integer> list, Set<TreeNode> set, Queue<TreeNode> queue, TreeNode target, int k)
    {
        queue.add(target);
        while(k > 0)
        {
            int size = queue.size();
            k--;
            for(int i  = 0; i < size; i++)
            {
                TreeNode temp = queue.poll();
                set.add(temp);
                for(TreeNode nei : hash.get(temp))
                {
                    if(!set.contains(nei))
                    queue.add(nei);
                }
            }
        }
        
        while(!queue.isEmpty())
        {
            list.add(queue.poll().val);
        }

    }
    
    
    
    public void fill(HashMap<TreeNode, ArrayList<TreeNode>> hash, Queue<TreeNode> queue, TreeNode root)
    {
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int k = 0; k < size; k++)
            {
                TreeNode temp =queue.poll();
                if(!hash.containsKey(temp)) hash.put(temp, new ArrayList());
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