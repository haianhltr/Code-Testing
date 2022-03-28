class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] catalog = new ArrayList[numCourses];
        int [] prereqs = new int [numCourses];
        
        for(int i = 0; i<catalog.length;i++)catalog[i] = new ArrayList<Integer>();
        
        for(int[]edge : prerequisites)
        {
            int a = edge[0];
            int b = edge[1];
            // them vao list nhung lop ma lop co lam prereqs
            catalog[b].add(a);
            //dem so prereqs can cho 1 class
            prereqs[a]++;
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int k = 0; k < numCourses; k++)
        {
            if(prereqs[k] == 0)
            {
                queue.add(k);
            }
        }
        
        while(!queue.isEmpty())
        {
            int course = queue.poll();
            numCourses--;
            for(int next : catalog[course])
            {
                prereqs[next]--;
                if(prereqs[next] == 0) queue.add(next);
            }
        }
        return numCourses == 0;
    }
}