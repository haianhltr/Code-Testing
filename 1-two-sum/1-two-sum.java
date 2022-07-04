class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap();
    
        for(int k =0; k< nums.length; k++)
        {
            int remain = target - nums[k];
            if(!hash.containsKey(remain))
            {
                  hash.put(nums[k],k); 
            }
            else{
                 return new int [] {k,hash.get(remain)};
                
            }
            
     
        }
        return null;
        
        
        
    }
}