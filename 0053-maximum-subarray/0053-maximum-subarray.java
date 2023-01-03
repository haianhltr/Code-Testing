class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = current;
        for(int k = 1; k < nums.length; k++)
        {
            current = Math.max(nums[k], current + nums[k]);
            max = Math.max(max, current);
        }
        return max;
    }
}