class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
   
        ArrayList<Integer> [] prereqs = new ArrayList[n];
        int [] count = new int [n];
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList<Integer>();
        }
        
        for(int [] temp : prerequisites)
        {
            int classCount = temp[0];
            int classNeighbor = temp[1];
            count[classCount]++;
            prereqs[classNeighbor].add(classCount);
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
            int temp = queue.poll();
            n--;
            for(int nei : prereqs[temp])
            {
                count[nei]--;
                if(count[nei] == 0)
                {
                    queue.add(nei);
               
                }
            }
        }
        
        return n == 0 ? true : false;
        
    }
}