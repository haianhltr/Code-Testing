class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] prereqs = new ArrayList[n];
        int [] count = new int [n];
        for(int k =0; k < n; k++)
        {
            prereqs[k] = new ArrayList();
        }
        
        for(int [] temp : prerequisites)
        {
            prereqs[temp[1]].add(temp[0]);
            count[temp[0]]++;
        }
        
        boolean [] visited = new boolean[n];
        
        for(int k = 0; k < count.length; k++)
        {
            if(count[k] == 0)
            {
                if(visited[k] == false)
                n = DFS(n, prereqs, count, k, visited);
            }
        }
        
        return n == 0 ? true  : false;
    }
    
    
    public int DFS(int n, ArrayList<Integer>[] prereqs, int [] count, int num, boolean [] visited)
    {
        n--;
        visited[num] = true;
        if(prereqs[num].size() == 0) 
        {
            return n;
        }
        
        for(int temp : prereqs[num])
        {
            count[temp]--;
            if(count[temp] == 0)
            {
                if(visited[temp] == false)
                n = DFS(n, prereqs, count, temp, visited);
            }
        }
        return n;
    }
}