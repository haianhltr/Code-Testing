class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
int [] result = new int [n];
        ArrayList<Integer>[] prereqs = new ArrayList[n];
        int [] count = new int [n];
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList();
            
        }
        
        for(int [] temp : prerequisites)
        {
            int a = temp[0];
            count[temp[0]]++;
            prereqs[temp[1]].add(temp[0]);
            
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int k =0; k < count.length; k++)
        {
            if(count[k] == 0)
            {
                queue.add(k);
                n--;
            }
        }
        int index = 0;
        
        while(!queue.isEmpty())
        {
            int temp = queue.poll();
            result[index++] = temp;
            for(int nei : prereqs[temp])
            {
                count[nei]--;
                if(count[nei] == 0)
                {
                    queue.add(nei);
                    n--;
                }
            }
        }
        
        return n==0 ? result : new int [0];
    }
}