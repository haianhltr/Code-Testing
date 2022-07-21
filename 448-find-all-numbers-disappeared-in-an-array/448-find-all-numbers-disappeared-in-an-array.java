class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int k = 0; k < nums.length; k++)
        {
            if(nums[Math.abs(nums[k])-1] > 0)
            {
                nums[Math.abs(nums[k])-1] *= -1;
            }
        }
        

        for(int k = 0; k < nums.length; k++)
        {
            if(nums[k] > 0)
            {
              list.add(k+1);
            }
        }
        return list;
    }
}



