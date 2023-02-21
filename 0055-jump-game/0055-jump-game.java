class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return DFS(nums, 0, dp);
    }
    
    private boolean DFS(int[] nums, int index, Boolean[] dp) {
        if (index >= nums.length - 1) {
            return true;
        }
        
        if (dp[index] != null) {
            return dp[index];
        }
        
        int furthestJump = Math.min(index + nums[index], nums.length - 1);
        for (int i = index + 1; i <= furthestJump; i++) {
            if (DFS(nums, i, dp)) {
                dp[index] = true;
                return true;
            }
        }
        
        dp[index] = false;
        return false;
    
}

}