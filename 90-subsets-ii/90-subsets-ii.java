class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrack(nums, 0, list, new ArrayList<>());
        return list;
    } 
    public void backtrack(int [] nums, int pos, List<List<Integer>> list, List<Integer> temp)
    {
        list.add(new ArrayList<>(temp));
        for(int k = pos; k < nums.length; k++)
        {
            if(k > pos && nums[k] == nums[k-1] ) continue;
            temp.add(nums[k]);
            backtrack(nums, k+1, list, temp);
            temp.remove(temp.size()-1);
            }
        }
    }
