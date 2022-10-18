class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      return  DFS(nums, target, 0, 0 , 0);
        
    }
    public int DFS(int [] nums, int target, int sum, int index, int count)
    {
        if(index == nums.length)
        {
            if(sum == target)
            {
                return 1;
            }
            return 0;
        }
        
       int a =  DFS(nums, target, sum + nums[index], index + 1, count);
       int b = DFS(nums, target, sum - nums[index], index + 1 , count);
        
        return a + b;
    }
}