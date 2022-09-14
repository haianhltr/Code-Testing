class Solution {
    
    Set<List<Integer>> set = new HashSet();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        recur(list,nums, 0, new ArrayList<>());
        return list;
    }
    
    
    public void recur(List<List<Integer>> list, int [] nums, int pos, List<Integer> temp)
    {
        if(!set.contains(temp)){
                set.add(temp);
               list.add(new ArrayList<>(temp)); 
        }
        
    
        
        for(int k = pos ; k < nums.length; k++)
        {
            temp.add(nums[k]);
            recur(list, nums, k+1, temp);
            temp.remove(temp.size() -1);
        }
    }
    
}


// [] [1] [1,2] [1,2,3] [2] [2,3]

// 0 1
// [1]

// [2]