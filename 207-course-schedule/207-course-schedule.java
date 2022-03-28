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
            
            int a =edge[0];
            int b = edge[1];
            prereqs[a]++;
            catalog[b].add(a);
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int k = 0; k < numCourses; k++)
        {
            if(prereqs[k]==0) queue.add(k);
        }
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            numCourses--;
            for(int next : catalog[current])
            {
                prereqs[next]--;
                if(prereqs[next] == 0)
                {
                    queue.add(next);
                }
            }
        }
        return numCourses == 0;

    }
}

// 3,1
// 3,2
// 1,2

// 3 1
// 1 0
// 2 0
    
// [1] {3}
// [2] {1,3}

// 2 1
 
    