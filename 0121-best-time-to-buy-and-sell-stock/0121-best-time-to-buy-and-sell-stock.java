class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = prices[0];
        for(int k = 1; k < prices.length; k++)
        {
            if(prices[k] < left)
            {
                left = prices[k];
            }
            else{
                
                max = Math.max(max, prices[k] - left);
            }
            
            
        }
        return max;
    }
}


