class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
       int [] rob1 = new int[nums.length-1];
       int [] rob2 = new int[nums.length-1];
        
        for(int k =0; k < nums.length - 1; k++)
        {
            //include first but not last
            rob1[k] = nums[k];
            //not first but last
            rob2[k] = nums[k + 1];
        }
        
        
        return Math.max(DFS(rob1), DFS(rob2));
    }
    
    
    public int DFS(int [] nums)
    {
        for(int k = 1; k < nums.length; k++)
        {
            if(k == 1) nums[k] = Math.max(nums[k], nums[k-1]);
            else nums[k] = Math.max(nums[k-1], nums[k] + nums[k-2]);
        }
        
        return nums[nums.length-1];
    }
}