class Solution {
        Set<Integer>  set = new HashSet();
    public boolean canFinish(int n, int[][] prerequisites) {
        int [] result = new int [n];
        ArrayList<Integer>[] prereqs = new ArrayList[n];
     
        int [] count = new int [n];
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList();
            
        }
        
        for(int [] temp : prerequisites)
        {
            count[temp[0]]++;
            prereqs[temp[1]].add(temp[0]);
        }
        
        for(int k = 0; k < count.length; k++)
        {
            if(count[k] == 0)
            {
                if(!set.contains(k))
                {
                     n--;
                   n = DFS(prereqs, count, n, k, 0, result); 
                }
              
            }
        }
        
        return (n == 0) ? true : false;
    }
    
    public int DFS(ArrayList<Integer>[] prereqs, int [] count, int n, int num, int index, int [] result)
    {   
        set.add(num);
        result[index++] = num;
        if(prereqs[num].size() == 0)
        {
            return n;
        }
        
        for(int a : prereqs[num])
        {
            count[a]--;
            if(count[a] == 0)
            {
                n--;
                n = DFS(prereqs, count, n, a, index, result);
            }
        }
        return n;
    }
}