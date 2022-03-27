class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> hashmap = new HashMap();
        for(int k = 0; k < nums.length; k++)
        {
            int mid = target - nums[k];
            if(hashmap.containsKey(mid))
            {
                return new int [] {k,hashmap.get(mid)};
            }
            else{
                hashmap.put(nums[k],k);
            }
        }
        return null;
   
    }
}