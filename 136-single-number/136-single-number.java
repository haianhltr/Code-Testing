class Solution {
    public int singleNumber(int[] nums) {
        int sum = nums[0];
        for(int k = 1; k < nums.length; k++)
        {
            sum^=nums[k];
        }
        return sum;
    }
}


