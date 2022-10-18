class Solution {
    int count = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        DFS(nums, target, 0, 0);
        return count;
    }
    
    public void DFS(int [] nums, int target, int index, int sum)
    {
        if(index == nums.length)
        {
        if(sum == target)
        {

            count++;
            
        }
         return;
        }
   
        
        DFS(nums, target, index + 1,  sum + nums[index]);
        DFS(nums, target, index + 1, sum - nums[index]);
    }
}

// first stack
// 0
// 0 + 1
// ----
// second stack
// index = 1
// 1 + 1
// -----
// i = 2
// 2 + 1
// ------
// i = 3
// 3 + 1
// -------
// i = 4
// 4 + 1 
// 4 - 1
// ------
// i = 5

// -----
// i = 5

    
    

// // // if sum add up = target 
// // // count++;
// // // 1 + 1 + 1 + 1 +1

