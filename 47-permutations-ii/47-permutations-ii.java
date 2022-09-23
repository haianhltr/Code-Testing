class Solution {
public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, boolean [] used)
    {
        if(temp.size() == nums.length)
        {
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int k = 0; k < nums.length; k++)
        {
            if(used[k] || k > 0 && nums[k] == nums[k-1] && !used[k-1]) continue;
            used[k] = true;
            temp.add(nums[k]);
            backtrack(list, temp, nums, used);
            used[k] = false;
            temp.remove(temp.size()-1);
        }
    
}}