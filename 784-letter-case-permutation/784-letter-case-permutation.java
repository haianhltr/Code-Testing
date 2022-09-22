class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list  = new ArrayList();
        backtrack(list, s.toCharArray(), 0);
        return list;
    }
    
    
    public void backtrack(List<String> list, char [] word, int pos)
    {
        list.add(new String(word));
        for(int k = pos; k < word.length; k++)
        {
            if(Character.isLetter(word[k]))
            {
                if(Character.isUpperCase(word[k]))
                {
                     
                     word[k] = Character.toLowerCase(word[k]);
                      backtrack(list, word, k+1);
                    word[k] = Character.toUpperCase(word[k]);
                }
                else
                {
                   word[k] = Character.toUpperCase(word[k]);
                     backtrack(list, word, k+1);
                     word[k] = Character.toLowerCase(word[k]);  
                }
            }
         
        }
    }
    
}

