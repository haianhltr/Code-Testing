class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> win = new ArrayList();
        List<Integer> lost = new ArrayList();
        Set<Integer> total = new HashSet();
         Set<Integer> totallost = new HashSet();
        HashMap<Integer, Integer> map = new HashMap();
        for(int [] temp : matches)
        {
            int a = temp[0];
            int b = temp[1];
            total.add(a);
            total.add(b);
            
        }
        
     
        for(int [] temp : matches)
        {  
            int a = temp[0];
            int b = temp[1];
            if(!map.containsKey(b) )
            {
                map.put(b,1);
            }
            else{
                int count = map.get(b);
                map.put(b, count+1);
            }
          
            total.remove(b);
            
        }
        
          for (int ele : total) {
            // Print HashSet data
            win.add(ele);
        }
         Collections.sort(win);
        
        map.forEach((key,value) ->
                    {
                        
                       if(value == 1) lost.add(key);
                    });
                    
             Collections.sort(lost);
        
        
        list.add(win);
        list.add(lost);
        return list;
 
    }
}