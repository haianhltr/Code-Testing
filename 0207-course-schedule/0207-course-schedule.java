class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer> [] prereqs = new ArrayList[n];
        int [] count = new int [n];
        for(int k = 0; k < n; k++)
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
                if(!visited[k])
                n = DFS(n, prereqs, count, visited, k);
            }
        }
        
        System.out.println(n);
        return n == 0 ? true : false;
    }
    
    public int DFS(int n, ArrayList<Integer>[] prereqs, int [] count, boolean [] visited, int num)
    {
        n--;
        visited[num] = true;
        if(prereqs[num].size() == 0) return n;
        
        for(int nei : prereqs[num])
        {
            count[nei]--;
            if(count[nei] == 0) 
            {
                if(!visited[nei])
                n = DFS(n, prereqs, count, visited, nei);
            }
        }
        return n;
    }
}
