class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> hash = new HashSet();
        for(int num : nums)
        {
            hash.add(num);
        }
        
        for(int k = 0; k < nums.length;k++)
        {
            if(!hash.contains(nums[k]-1))
            {
                int currentMax = 1;
                int currentNum = nums[k];
                while(hash.contains(currentNum+1))
                {
                    currentMax++;
                    currentNum++;
                }
                max = Math.max(max,currentMax);
            }
          
        }
        
        return max;
        
        
    }
}