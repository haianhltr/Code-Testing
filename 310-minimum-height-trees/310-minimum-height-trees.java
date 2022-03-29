class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         List<Integer> list = new ArrayList<Integer>();
        if(n == 1)
        {
            list.add(0);
            return list;
        }
       
        ArrayList<Integer>[] connection = new ArrayList[n];
        int [] count = new int[n];
        for(int k = 0; k < n; k++)
        {
            connection[k] = new ArrayList<Integer>();
        }
        
        for(int [] edge : edges)
        {
            int a =edge[0];
            int b= edge[1];
            connection[a].add(b);
            connection[b].add(a);
            count[a]++;
            count[b]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int k = 0; k < n ; k++)
        {
            if(count[k] == 1)
            { 
                queue.add(k);
            
            }
        }
        
        while(n > 2)
        {
            int size = queue.size();
            n -= size;
            
            while(size-->0)
            {
                int current = queue.poll();
          
                for(int neighbor : connection[current])
                {
                    count[neighbor]--;
                    if(count[neighbor]==1)
                    {
                        queue.add(neighbor);
                    }
                }
            }
          
        }
        list.addAll(queue);
        return list;
        
        
        
        
    }
}