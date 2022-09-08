class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {

        ArrayList<Integer> [] prereqs = new ArrayList[n];
        int [] count = new int [n];
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList<Integer>();
        }
        for(int [] p : prerequisites)
        {
            int a = p[0];
            int b = p[1];
            count[a]++;
            prereqs[b].add(a);
        }
        Queue<Integer> queue = new LinkedList();
        for(int k = 0; k < n; k++)
        {
            if(count[k] == 0)
            {
                queue.add(k);
            }
        }
        
        
        while(!queue.isEmpty())
        {
            int current =  queue.poll();
            n--;
            for(int num : prereqs[current])
            {
                count[num]--;
                if(count[num] == 0)
                {
                    queue.add(num);
                    
                }
            }
        }
        
         return n!=0 ? false : true ;
      
        
    
    }
}