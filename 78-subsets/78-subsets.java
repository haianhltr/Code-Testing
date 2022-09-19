class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList<>(), 0, nums);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int pos, int [] nums)
    {
      if(pos == nums.length)
      {
          list.add(new ArrayList<>(temp));
          return;
      }
    
        temp.add(nums[pos]);
        backtrack(list, temp, pos+1, nums);
        temp.remove(temp.size()-1);
        backtrack(list, temp, pos+1, nums);
    }
}