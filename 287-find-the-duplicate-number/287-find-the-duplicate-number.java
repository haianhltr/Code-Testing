class Solution {
    public int findDuplicate(int[] nums) {
        for(int k = 0; k < nums.length; k++)
        {
            if(nums[Math.abs(nums[k])-1] > 0)
            {
                nums[Math.abs(nums[k])-1] *= -1;
            }
            else{
                return Math.abs(nums[k]);
            }
        }
        return 0;
    }
}