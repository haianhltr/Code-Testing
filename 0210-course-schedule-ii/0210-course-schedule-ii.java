class Solution {
    Set<Integer> set = new HashSet();
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer>[] prereqs= new ArrayList[n];
        int [] count = new int [n];
        int [] result = new int[n];
        List<Integer> list = new ArrayList();
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList();
            
        }
        
        for(int [] temp : prerequisites)
        {
            prereqs[temp[1]].add(temp[0]);
            count[temp[0]]++;
        }
        
        for(int k = 0; k < count.length; k++)
        {
            if(count[k] == 0)
            {
                if(!set.contains(k))
                {
                    n = DFS(prereqs, count, list, k, n);
                }
            }
        }
        
        if(n == 0){
            
        
        for(int k = 0; k < result.length; k++)
        {
            result[k] = list.get(k);
        }
        }
        
        return n == 0 ? result : new int [] {};
            
    }
    
    public int DFS(ArrayList<Integer>[] prereqs, int [] count, List<Integer> list, int num, int n)
    {
        set.add(num);
        n--;
        list.add(num);
        if(prereqs[num].size() == 0)
        {
            return n;
        }
        
        for(int nei : prereqs[num])
        {
            count[nei]--;
            if(count[nei] == 0)
            {
                n = DFS(prereqs, count, list, nei, n);
            }
         }
        
        return n;
    }
}