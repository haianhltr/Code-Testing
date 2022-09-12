class Solution {
public List distanceK(TreeNode root, TreeNode target, int k)
{
    //hashmap to store parent of each node
    HashMap<TreeNode,TreeNode> parent_track=new HashMap<>();
    //helper function to calculate parent of each node
    store_parents(root,parent_track);
  
    Queue<TreeNode> q = new LinkedList<>();
    //visited hashmap 
    HashMap<TreeNode,Boolean> visited = new HashMap<>();
    q.offer(target);
    visited.put(target,true);
    int distance = 0;  //keeps track of distance
    //bfs traversal on left child, right child and parent
    while(!q.isEmpty())
    {
        if(distance==k)
            break;
        int q_size = q.size();
        for(int i=0;i<q_size;i++)
        {
            TreeNode temp=q.poll();
            if(temp.left!=null && visited.get(temp.left)==null)
            {
                q.offer(temp.left);
                visited.put(temp.left,true);
            }
            if(temp.right!=null && visited.get(temp.right)==null)
            {
                q.offer(temp.right);
                visited.put(temp.right,true);
            }
            if(parent_track.get(temp)!=null && visited.get(parent_track.get(temp))==null)
            {
                q.offer(parent_track.get(temp));
                visited.put(parent_track.get(temp),true);
            }
        }
        distance++;
    }
    //storing result at last
    List<Integer> result =new ArrayList<Integer>();
    while(!q.isEmpty())
    {
        result.add(q.poll().val);
    }
    return result;
}
    
public void store_parents(TreeNode root,HashMap<TreeNode,TreeNode> parent_track)
{
    Queue<TreeNode> q=new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty())
    {
        int q_size = q.size();
        for(int i=0;i<q_size;i++)
        {
            TreeNode temp = q.poll();
            if(temp.left!=null)
            {
                q.offer(temp.left);
                parent_track.put(temp.left,temp);
            }
            if(temp.right!=null)
            {
                q.offer(temp.right);
                parent_track.put(temp.right,temp);
            }
        }
    }
}

}