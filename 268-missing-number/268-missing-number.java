class Solution {
    public int missingNumber(int[] nums) {
        
        int sum = (nums.length) * (nums.length + 1)/2;
        System.out.println(sum);
        for(int k = 0; k < nums.length; k++)
        {
            sum = sum - nums[k];
        }
        
        return sum;
        
    }
}

