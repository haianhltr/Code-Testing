class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = 1; 
        ArrayList<Integer> dp = new ArrayList();
        dp.add(0);
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] <= nums[dp.get(0)])
            {
               dp.set(0,i);
            }
            else if(nums[i] > nums[dp.get(length-1)])
            {
                dp.add(i);
                length++;
            }
            else{
                int pos = lowerBound(nums, dp, length, nums[i]);
                dp.set(pos, i);
            }
        }
                                   return length;
    }
    
    
    public static int lowerBound(int [] nums, ArrayList<Integer> dp, int len, int num)
    {
        int left = 0; 
        int right = len;
        int pos = len;
        while(left < right)
        {
            int mid = left + (right - left)/2;
            int index = dp.get(mid);
            if(nums[index] >= num)
            {
                pos = mid;
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return pos;
    }
}