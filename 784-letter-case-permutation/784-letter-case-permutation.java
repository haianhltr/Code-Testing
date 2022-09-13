class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList();
        recur(s.toCharArray(), 0, list);
        return list;
        
    }
    
    public void recur(char [] str, int pos, List<String> result)
    {
        if(pos == str.length)
        {
            result.add(new String(str));
            return;
        }
        
        if(Character.isLetter(str[pos]))
        {
            if(Character.isUpperCase(str[pos]))
            {
                str[pos] = Character.toLowerCase(str[pos]);
                recur(str, pos+1, result);
                str[pos] = Character.toUpperCase(str[pos]);
            }
        
        else
        {
            str[pos] = Character.toUpperCase(str[pos]);
            recur(str, pos+1, result);
            str[pos] = Character.toLowerCase(str[pos]);
        }
    }
        recur(str, pos+1, result);
}}