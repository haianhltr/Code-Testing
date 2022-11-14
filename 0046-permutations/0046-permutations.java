class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList(), nums);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums)
    {
        if(temp.size() == nums.length)
        {
            list.add(new ArrayList(temp));
            return;
        }
        
        for(int k = 0; k < nums.length; k++)
        {
            if(temp.contains(nums[k])) continue;
            temp.add(nums[k]);
            backtrack(list, temp, nums);
            temp.remove(temp.size()-1);
        }
    }
}