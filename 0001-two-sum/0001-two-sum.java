class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap();
        for(int k = 0; k < nums.length; k++)
        {
            int result = target - nums[k];
            if(hash.containsKey(result))
            {
                return new int [] {k, hash.get(result)};
            }
            else
            {
                hash.put(nums[k], k);
            }
        }
        return new int [] {};
    }
    
  
}

