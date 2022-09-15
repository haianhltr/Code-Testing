class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(nums, 0, list, new ArrayList<>());
        return list;
    }
  public void  backtrack(int [] nums, int pos, List<List<Integer>> list, List<Integer> temp)
    {
        if(pos == nums.length) 
        {
            list.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[pos]);
        backtrack(nums,pos+1, list, temp);
        temp.remove(temp.size()-1);
        backtrack(nums,pos+1, list,temp);
    }
}