class Solution {
         Set<Integer> set = new HashSet();
    public boolean canFinish(int n, int[][] prerequisites) {
 
        ArrayList<Integer>[] prereqs = new ArrayList[n];
        int [] count = new int [n];
        for(int k = 0; k < n; k++)
        {prereqs[k] = new ArrayList<Integer>();}
        
        for(int [] pre : prerequisites)
        {int a = pre[0];int b = pre[1];count[a]++;prereqs[b].add(a);}
        for(int k = 0; k < count.length; k++)
        {
            if(count[k] == 0)
            {
                if(!set.contains(k))
                { 
                    n--;
                       System.out.println("n" + n);
                    n =  DFS(n, k, count, prereqs);   
                }
            System.out.println(n);
            }
        }
        return n==0 ? true : false;
    }
    public int DFS(int n, int num, int [] count, ArrayList<Integer>[] prereqs)
    {
        set.add(num);
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
                n = DFS(n, a ,count, prereqs);
            }
        }
           return n;
    }
}