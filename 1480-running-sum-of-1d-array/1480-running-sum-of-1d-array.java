class Solution {
    public int[] runningSum(int[] nums) {
        int start = 0;
        for(int k = 0; k < nums.length;k++)
        {
            start += nums[k];
            nums[k] = start;
        }
        return nums;
    }
}