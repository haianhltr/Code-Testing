class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        DFS(nums, target, 0, 0);
        return count;
    }
    
    public void DFS(int [] nums, int target, int pos, int sum)
    {
        if(pos == nums.length)
        {
            if(sum == target)
            {
                count++;
            }
            return;
        }
        
        DFS(nums, target, pos + 1, sum + nums[pos]);
        DFS(nums, target, pos + 1, sum - nums[pos]);
    }
}