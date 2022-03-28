class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
           // what do i need, an array to store num of class need to be taken before take that class
        int check = 0;
       int [] result = new int [n]; 
       int [] pre = new int [n];
        // an array of class that the class can satisfy
         ArrayList<Integer> [] catalog = new ArrayList[n];
        //A queue to keep track
        Queue<Integer> queue = new LinkedList();
        //boolean to return
        
        //since catalog is empty i need to generate object for it
        for(int k =0; k < catalog.length; k++)
        {
            catalog[k]=  new ArrayList<Integer>();
        }
        
        //now I need to put variables in catalog and prereqs
        for(int [] edge : prerequisites)
        {
            int a = edge[0];
            int b = edge[1];
            catalog[b].add(a);
            pre[a]++;
        }
        
        for(int k = 0; k < n ; k++)
        {
            if(pre[k] == 0) 
            {
                queue.add(k);
                // check = 1;
            }
        }
        // if(check == 0) return new int[0];
        // check = 0;
        int k = 0;
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            result[k++] = current;
            n--;
            for(int num : catalog[current])
            {
                pre[num]--;
                if(pre[num] == 0) queue.add(num);
                
            }
        }
        
        
        return n == 0 ? result : new int [0];
    }
}