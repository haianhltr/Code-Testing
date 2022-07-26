class Solution {
    public int firstMissingPositive(int[] nums) {
      
        for(int k = 0; k < nums.length; k++)
        {
            if(nums[k] < 0)
            {
                 nums[k] = 0;
            }
           
        }
        
        for(int k = 0; k < nums.length;k++)
        {
            if(nums[k] == 0 || Math.abs(nums[k])-1 >= nums.length)
                continue;
            if(nums[Math.abs(nums[k]) -1] > 0)
            {
                nums[Math.abs(nums[k]) -1] *= -1;
            }
              if(nums[Math.abs(nums[k]) -1] == 0)
            {
                nums[Math.abs(nums[k]) -1] = (nums.length+1)*-1;
            }
         
            
        }
        

        for(int k = 1; k <= nums.length;k++)
        {
            if(nums[k-1] >= 0)
            {
                return k;
            }
        
        }
        
        return nums.length+1;
        
    }
}

