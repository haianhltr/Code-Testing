class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {

       int [] result = new int [n];
        ArrayList<Integer> [] prereqs = new ArrayList[n];
        int [] count = new int [n];
        for(int k = 0 ; k < n; k++)
        {
            prereqs[k] = new ArrayList<Integer>();
        }
        
        for(int [] current : prerequisites)
        {
            int a = current[0];
            int b = current[1];
            prereqs[b].add(a);
            count[a]++;
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int k = 0; k < n; k++)
        {
            if(count[k] == 0)
            queue.add(k);
        }
        
        //BFS
        int k = 0;
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            result[k++] = current;
            n--;
            for(int neighbor : prereqs[current])
            {
                count[neighbor]--;
                if(count[neighbor] == 0)
                {
                    queue.add(neighbor);
                }
                
            }
        }
        
       
        return n == 0 ? result : new int [] {};
        
    }
}