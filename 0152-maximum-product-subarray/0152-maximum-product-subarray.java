class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for(int k = 0; k < nums.length; k++)
        {
            int sum = 1;
            for(int j = k; j >= 0; j--)
            {
                sum *= nums[j];
                max = Math.max(max, sum);
            }
       
        }
        return max;
    }
}