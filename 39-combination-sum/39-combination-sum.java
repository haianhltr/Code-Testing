class Solution {
   public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
 backtrack(list, new ArrayList(), nums, 0 , target, 0); 
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int sum, int target, int pos){
    if(sum > target) return;
    else if(sum == target) list.add(new ArrayList<>(tempList));
    else{ 
        for(int i = pos; i < nums.length; i++){
            tempList.add(nums[i]);
            sum += nums[i];
            backtrack(list, tempList, nums, sum , target, i); 
            sum -= nums[i];
            tempList.remove(tempList.size() - 1);
        }
    }
}
}