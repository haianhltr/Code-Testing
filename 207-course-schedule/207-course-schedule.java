class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer> [] prereqs = new ArrayList[n];

        int [] count = new int [n];
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList<Integer>();
        }
        
        for(int [] current : prerequisites)
        {
            int a  = current[0];
            int b = current[1];
            prereqs[b].add(a);
            count[a]++;
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
        
        return n==0;
    
        
        
    }
}