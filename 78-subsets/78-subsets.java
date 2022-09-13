class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums,0);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int pos)
    {
        list.add(new ArrayList<>(tempList));
        for(int k = pos; k < nums.length; k++)
        {
            tempList.add(nums[k]);
            backtrack(list,tempList, nums, k+1);
            tempList.remove(tempList.size()-1);
        }
    }
}