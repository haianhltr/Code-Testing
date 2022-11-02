class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int target) {
        DFS(nums, target, 0, 0);
        return count;
    }
    
    public void DFS(int [] nums, int target, int sum, int pos)
    {
      
        if(pos == nums.length)
        {
            if(sum == target)
            {
                count++;
            }
            return;
        }
        
        DFS(nums, target, sum + nums[pos], pos + 1);
        DFS(nums, target, sum - nums[pos], pos + 1);
        
        
    }
}


