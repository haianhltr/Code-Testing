class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        DFS(nums, target,0, 0);
        return count;
    }
    
    public void DFS(int [] nums, int target, int sum, int index)
    {
        if(index == nums.length)
        {
            if(sum == target)
            {
                count++;
            }
                            return;

        }
        
        DFS(nums, target, sum + nums[index], index + 1);
        DFS(nums,target, sum - nums[index], index + 1);
    }
    
}