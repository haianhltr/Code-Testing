class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> list = new ArrayList();
        backtrack(nums, 0, list, new ArrayList<Integer>());
            return list;
    }
    
    public void backtrack(int [] nums, int pos, List<List<Integer>> list, List<Integer> temp)
    {
        list.add(new ArrayList<Integer>(temp));
        for(int k = pos; k < nums.length; k++)
        {
            temp.add(nums[k]);
            backtrack(nums, k+1, list, temp);
            temp.remove(temp.size()-1);
        }
    }
}