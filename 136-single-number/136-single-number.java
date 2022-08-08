class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int k = 1; k < nums.length; k++)
        {
            result^= nums[k];
        }
        return result;
    }
}