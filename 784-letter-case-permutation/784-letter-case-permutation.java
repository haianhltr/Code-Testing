class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList();
        backtrack(s.toCharArray(), list, 0);
        return list;
    }
    
    public void backtrack(char [] word, List<String> list, int pos)
    {
        if(pos == word.length)
        {
            list.add(new String(word));
            return;
        }
        
        if(Character.isLetter(word[pos]))
        {
            if(Character.isUpperCase(word[pos]))
            {
                word[pos] = Character.toLowerCase(word[pos]);
                backtrack(word, list, pos+1);
                word[pos] = Character.toUpperCase(word[pos]);
            }
            else
            {
                word[pos] = Character.toUpperCase(word[pos]);
                backtrack(word, list, pos+1);
                word[pos] = Character.toLowerCase(word[pos]);
            }
        }
        
        backtrack(word,list, pos+1);
    }
}