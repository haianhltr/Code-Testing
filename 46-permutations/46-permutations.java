class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, nums, new ArrayList<>());
        return list;
    }
    public void backtrack(List<List<Integer>> list, int [] nums, List<Integer>temp)
    {
        if(temp.size() == nums.length)
        {
            list.add(new ArrayList<>(temp));
            return;
        }
     
            for(int k = 0; k < nums.length; k++)
            {
                if(temp.contains(nums[k])) continue;
                temp.add(nums[k]);
                backtrack(list, nums, temp);
                temp.remove(temp.size()-1);
            }
        
    }
}


// [1,2,3]