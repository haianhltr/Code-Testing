class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList<>(), nums,0);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, int pos)
    {
        list.add(new ArrayList<>(temp));
        for(int k = pos; k < nums.length; k++)
        {
            temp.add(nums[k]);
            backtrack(list, temp, nums, k+1);
            temp.remove(temp.size()-1);
        }
    }
}