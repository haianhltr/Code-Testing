class Solution {
    public int rob(int[] nums) {
        for(int k = 1; k < nums.length; k++)
        {
            if(k == 1) nums[k]  = Math.max(nums[k-1], nums[k]);
            else
                nums[k] = Math.max(nums[k-1], nums[k] + nums[k-2]);
        }
        
        return nums[nums.length-1];
    }
}

// 9 8 7  6  100 103
// 9 9 16 16 116 119