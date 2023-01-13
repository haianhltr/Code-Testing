class Solution {
    public int maxProduct(int[] nums) {
        int ans = Arrays.stream(nums).max().getAsInt();
        int max = 1;
        int min = 1;
        for(int k = 0 ; k < nums.length; k++)
        {
            if(nums[k] == 0) 
            {
                max = 1;
                min = 1;
                continue;
            }
            
            int temp = max;
            max = Math.max(Math.max(max * nums[k], min * nums[k]), nums[k]);
            min = Math.min(Math.min(temp * nums[k], min * nums[k]), nums[k]);
            ans = Math.max(ans, max);
        }
return ans;
    }
}

     