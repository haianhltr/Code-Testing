class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length + 0)*(nums.length+1)/2;
        
        
      for(int k = 0; k < nums.length; k++)
      {
        sum -= nums[k];
      }
        return sum;
      
    }
}


      