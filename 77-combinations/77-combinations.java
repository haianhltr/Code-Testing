class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList<>(), n, k , 1);
        
        
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int n, int k, int pos)
    {
        if(temp.size() == k)
        {
            list.add(new ArrayList(temp));
            return;
        }
        
        for(int i = pos; i <= n; i++)
        {
            temp.add(i);
            backtrack(list, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
        
    }
    
}


