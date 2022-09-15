class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, list, new ArrayList<>());
        return list;
    }
    
    public void backtrack(int [] nums, List<List<Integer>> list, List<Integer> temp)
    {
        if(temp.size() == nums.length)
        {
            list.add(new ArrayList<>(temp));
            return;
    
        }
        for(int k =0; k < nums.length; k++)
        {
                if(temp.contains(nums[k])) continue;
            temp.add(nums[k]);
            backtrack(nums,list, temp);
            temp.remove(temp.size()-1);
        }
       
    }
}
