class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int [] arr1 = new int[n-1];
        int [] arr2 = new int[n-1];
        for(int k =0; k < n-1; k++)
        {
            arr1[k] = nums[k]; //include first but not last element
            arr2[k] = nums[k+1]; //not include first but last element;
        }
  

        //top down
        int x = arr1.length-1;
        int [] dp1 = new int[x + 1];
        int [] dp2 = new int[x + 1];
        for(int k = 0; k < x + 1; k++)
        {
            dp1[k] = -1;
            dp2[k] = -1;
        }
        
        int ans1 = calc(arr1, x, dp1);
        int ans2 = calc(arr2, x, dp2);
        
        return Math.max(ans1, ans2);
        
    }
 
    public int calc(int [] nums, int index, int [] dp)
    {
        if(index == 0) return nums[0];
        if(index < 0) return 0;
        if(dp[index] != -1)
        {
            return dp[index];
        }
        
        int include = calc(nums, index - 2, dp) + nums[index];
        int exclude = calc(nums, index-1, dp);
        return dp[index] = Math.max(include, exclude);
    }
}




