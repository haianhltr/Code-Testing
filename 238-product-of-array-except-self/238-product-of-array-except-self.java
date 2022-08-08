class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int [nums.length];
        int left = 1;
        for(int k = 0; k < nums.length; k++)
        {
            result[k] = left;
            left *= nums[k];
        }
        left = 1;
        for(int k = nums.length-1; k>= 0; k--)
        {
            result[k] *= left;
            left *=  nums[k];
        }
        
        return result;
    }
}