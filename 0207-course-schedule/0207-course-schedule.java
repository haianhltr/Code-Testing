public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
       for(int [] temp : prerequisites)
        {
            int classCount = temp[0];
            int classNeighbor = temp[1];
             degree[classCount]++;
            graph[classNeighbor].add(classCount);
        }
        
        
        
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                numCourses--;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                   numCourses--;
                }
            }
        }
        if(numCourses == 0)
            return true;
        else    
            return false;
    }
}