class Solution {
    public int rob(int[] nums) {
        for(int k = 1; k < nums.length; k++)
        {
            if(k == 1)
            {
                nums[k] = Math.max(nums[k], nums[k-1]);
            }
            else
            {
                nums[k] = Math.max(nums[k-1], nums[k] + nums[k-2]);
            }
        }
        
        return nums[nums.length-1];
    }
}

