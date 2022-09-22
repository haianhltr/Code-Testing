class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrack(nums, 0, list, new ArrayList<>(), new boolean[nums.length]);
        return list;
    }
    
    public void backtrack(int [] nums, int pos, List<List<Integer>> list, List<Integer> temp,boolean [] used)
    {
        list.add(new ArrayList<>(temp));
        for(int k = pos; k < nums.length; k++)
        {
            if(used[k] || k > pos && nums[k] == nums[k-1] && !used[k - 1]) continue;
            used[k] = true; 
            temp.add(nums[k]);
            backtrack(nums, k+1, list, temp,used);
                  used[k] = false; 
            temp.remove(temp.size()-1);
            }
         
            
        }
    }
