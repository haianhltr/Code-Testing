class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet();
        int longestStreak = 0;
        for(int num : nums)
        {
            hash.add(num);
        }
        
        for(int k = 0; k < nums.length; k++)
        {
            if(!hash.contains(nums[k]-1))
            {
                int currentStreak = 1;
                int currentNum = nums[k];
                while(hash.contains(currentNum+1))
                {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
                
            }
        }
        return longestStreak;
    }
}