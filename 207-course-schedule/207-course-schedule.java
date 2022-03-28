class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> [] catalog = new ArrayList[numCourses];
        int [] prereqs = new int [numCourses]; 
        for(int k = 0 ; k < catalog.length; k++)
        {
            catalog[k] = new ArrayList<Integer>();
        }
        
        for(int [] edge : prerequisites)
        {
            int a = edge[0];
            int b = edge[1];
            catalog[b].add(a);
            prereqs[a]++;
            
        }
        Queue<Integer> queue = new LinkedList();
        for(int k = 0; k < numCourses; k++)
        {
            if(prereqs[k] == 0)
            queue.add(k);
        }
            
        while(!queue.isEmpty())
        {
            int classTaking = queue.poll();
            numCourses--;
            for(int n : catalog[classTaking])
            {
                prereqs[n]--;
                if(prereqs[n] == 0) queue.add(n);
            }
        }
        return numCourses == 0;
    }
}