class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length-1;
        for(int k = nums.length - 1; k >= 0; k--)
        {
            if(k + nums[k] >= lastPos)
            lastPos = k;
        }
        return lastPos == 0;
    }
}