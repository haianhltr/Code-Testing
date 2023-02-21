class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for(int k = 1; k < nums.length; k++)
        {
            int temp = currentMax;
            currentMax = Math.max(Math.max(nums[k] * currentMax, nums[k] * currentMin), nums[k]);
            currentMin = Math.min(Math.min(nums[k] * temp, nums[k] * currentMin), nums[k]);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}