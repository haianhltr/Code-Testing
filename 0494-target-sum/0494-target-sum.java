class Solution {
    int count =0;
    public int findTargetSumWays(int[] nums, int target) {
        DFS(nums, 0, target, 0);
        return count;
    }
    
    public void DFS(int [] nums, int pos, int target, int sum)
    {
        if(pos == nums.length)
        {
            if(target == sum) count++;
            return;
        }
        DFS(nums, pos + 1, target, sum + nums[pos]);
        DFS(nums, pos  + 1, target, sum - nums[pos]);
    }
}