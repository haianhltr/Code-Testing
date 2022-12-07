class Solution {
    List<Integer> list = new ArrayList();
    public int[] findOrder(int n, int[][] prerequisites) {
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
                if(visited[k] == false)
                n = DFS(prereqs, count, visited, n, k);
            }
        }

       int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        
        return n == 0 ? result : new int [] {};
    }
    public int DFS(ArrayList<Integer> [] prereqs, int [] count, boolean [] visited, int n, int num)
    {
        visited[num] = true;
        n--;
        list.add(num);
        if(prereqs[num].size()== 0) return n;
        for(int nei : prereqs[num])
        {
            count[nei]--;
            if(count[nei] == 0)
            {
                n = DFS(prereqs, count, visited, n, nei);
            }
        }
        return n;
    }
}