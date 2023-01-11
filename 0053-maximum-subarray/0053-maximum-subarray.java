class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for(int k = 1; k < nums.length; k++)
        {
            currentMax = Math.max(nums[k], currentMax + nums[k]);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}