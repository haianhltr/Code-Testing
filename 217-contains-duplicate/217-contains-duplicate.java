class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet();
        for (int k = 0; k < nums.length; k ++)
        {
            if(!hash.contains(nums[k]))
            {
                hash.add(nums[k]);
            }
            else{
                return true;
            }
        }
        return false;
    }
}