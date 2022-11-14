class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList(), 0, nums);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int pos, int [] nums)
    {
        list.add(new ArrayList(temp));
        for(int k = pos; k < nums.length; k++)
        {
            if(k > pos && nums[k] == nums[k-1]) continue;
            temp.add(nums[k]);
            backtrack(list, temp, k + 1, nums);
            temp.remove(temp.size()-1);
        }
    }
}