class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
         
        recur(nums, 0, list, new ArrayList<>());
        return list;
    }
    
    public void recur(int [] nums, int pos, List<List<Integer>> list, List<Integer> temp)
    {
     
            list.add(new ArrayList<>(temp));
      
        
        for(int k = pos; k < nums.length; k++)
        {
            temp.add(nums[k]);
            recur(nums, k+1, list, temp);
            temp.remove(temp.size()-1);
            
        }
        
    
    }
}


