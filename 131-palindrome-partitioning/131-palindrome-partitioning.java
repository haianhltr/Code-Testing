class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList();
        backtrack(list, new ArrayList(), s, 0);
        return list;
    }
    
    public void backtrack(List<List<String>> list, List<String> temp, String s, int pos)
    {
        if(pos == s.length())
        {
            list.add(new ArrayList(temp));
            return;
        }
        
        
        for(int k = pos; k < s.length(); k++)
        {
                if(isPalindrome(s, pos, k))
                {
                    temp.add(s.substring(pos, k + 1));
                    backtrack(list, temp, s, k + 1);
                    temp.remove(temp.size()-1);
                }
        }
    }
    
    
    public boolean isPalindrome(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        
        return true;
    }
}