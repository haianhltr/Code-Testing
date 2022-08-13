class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int [] count = new int [n];
        ArrayList<Integer> [] prereqs = new ArrayList [n];
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList<Integer>();
        }
        
        
        for(int [] current : prerequisites)
        {
         int a = current[0];
         int b = current[1];
         count[a]++;
         prereqs[b].add(a);   
        }
        
        Queue<Integer> queue = new LinkedList();
        
        
        for(int k = 0; k < n ; k++)
        {
            if(count[k] == 0)
            queue.add(k);
        }
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            n--;
            for(int c : prereqs[current])
            {
                count[c]--;
             
                if(count[c] == 0)
                {
                    queue.add(c);
                }
            }
            
        }
        return n==0 ? true : false;
    }
}