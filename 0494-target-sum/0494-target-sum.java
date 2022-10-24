class Solution {
    int count = 0;
 
    public int findTargetSumWays(int[] nums, int target) {
        findSum(nums, target, 0, 0);
        return count;
    }
    
    public void findSum(int [] nums, int target, int index, int sum)
    {
        if(index == nums.length)
        {
            if(sum == target)
        {
            count++;
          
        }
              return;
        }
        
        findSum(nums, target, index + 1, sum + nums[index]);
        findSum(nums,target, index+1, sum - nums[index]);
    }
}


