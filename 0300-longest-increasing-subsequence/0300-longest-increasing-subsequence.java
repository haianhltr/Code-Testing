class Solution {
    public int lengthOfLIS(int[] nums) {
            int length = 0;
            List<Integer> dp = new ArrayList();
            for(int k = 0; k < nums.length; k++)
            {
                dp.add(1);
            }
            for(int i = 1; i < nums.length; i++)
            {
                for(int j = 0; j < i; j++)
                {
                    if(nums[i] > nums[j] && dp.get(i)  < dp.get(j) + 1)
                    {
                        dp.set(i, dp.get(j) + 1);
                    }
                }
            }
        
        for(int a : dp)
        {
            length = Math.max(a, length);
        }
        return length;
    }
}