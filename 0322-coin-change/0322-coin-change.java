class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int [amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int k = 1; k <= amount; k++)
        {
            for(int coin : coins)
            {
                if(k - coin >= 0)
                {
                    dp[k] = Math.min(dp[k], 1 + dp[k - coin]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1; 
    }
}

