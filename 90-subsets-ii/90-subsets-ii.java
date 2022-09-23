class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
           List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums,0);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, int pos)
    {
        list.add(new ArrayList<>(temp));
        for(int k = pos; k < nums.length; k++)
        {
            if(k > pos && nums[k-1] == nums[k]) continue;
            temp.add(nums[k]);
            backtrack(list, temp, nums, k+1);
            temp.remove(temp.size()-1);
        }
    }
}


