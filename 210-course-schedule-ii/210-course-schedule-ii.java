class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {

        List<Integer> list = new ArrayList();
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
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            list.add(current);
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
        
        int [] result = new int [list.size()];
        for(int k = 0; k < list.size(); k++)
        {
            result[k] = list.get(k);
        }
        return n == 0 ? result : new int [] {};
        
    }
}