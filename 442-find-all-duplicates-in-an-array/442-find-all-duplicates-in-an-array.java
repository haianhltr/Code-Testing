class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> list = new ArrayList();
        for(int k = 0; k < nums.length; k++)
        {
            if(nums[Math.abs(nums[k])-1] > 0)
            {
                nums[Math.abs(nums[k])-1] *= -1;
            }
            else
            {
                list.add(Math.abs(nums[k]));
            }
        }
        return list;
    }
}