class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer> [] prereqs = new ArrayList [n];
        int [] count = new int [n];
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
            for(int neighbor : prereqs[temp])
            {
                count[neighbor]--;
                if(count[neighbor] == 0)
                {
                    queue.add(neighbor);
                }
            }
        }
        return n==0;
    }
}