class Solution {
    public int missingNumber(int[] nums) {
        
        
        for(int k = 0; k < nums.length; k++)
        {
            if(nums[k] == 0 || Math.abs(nums[k]) >nums.length) continue;
            if(nums[Math.abs(nums[k])-1] == 0)
            {
                nums[Math.abs(nums[k])-1] = (nums.length+1)*-1;
            }
            else if(nums[Math.abs(nums[k])-1] > 0)
            {
                nums[Math.abs(nums[k])-1] *= -1;
            }
        
        }
        
        for(int k = 1; k <= nums.length; k++)
        {
            if(nums[k-1] >= 0)
            {
                return k;
            }
        }
        
        return 0;
    }
}

// [-3,0,-1]
 
// 1

 
// [1]

// 0 1 2 