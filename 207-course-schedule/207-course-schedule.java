class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer> [] catalog  =  new ArrayList[n];
        int [] prereqs = new int [n];
        for(int k = 0 ; k < catalog.length; k++)
        {
            catalog[k] = new ArrayList<Integer>();
        }
        
        for(int [] edge : prerequisites)
        {
            int a = edge[0];
            int b = edge[1];
            catalog[b].add(a);
            prereqs[a]++;
        }
        Queue<Integer> queue = new LinkedList();
        for(int k = 0 ; k < n; k++)
        {
            if(prereqs[k] == 0)
            {
                queue.add(k);
            }
        }
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            n--;
            for(int k : catalog[current])
            {
                prereqs[k]--;
                if(prereqs[k] == 0) queue.add(k);
            }
        }
        return n == 0;
        
    }
}