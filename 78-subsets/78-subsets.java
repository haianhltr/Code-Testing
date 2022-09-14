class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList<Integer>(), 0, nums);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int pos, int [] nums)
    {
       list.add(new ArrayList<>(temp));
        for(int k = pos; k < nums.length; k++)
        {
            temp.add(nums[k]);
            backtrack(list, temp, k+1, nums);
            temp.remove(temp.size()-1);
            
        }
        
    }
        
}





 