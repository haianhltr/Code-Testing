class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList();
        backtrack(list, 0, s.toCharArray());
        return list;
    }
    
    
    public void backtrack(List<String> list, int pos, char [] letter)
    {
        if(pos == letter.length)
        {
            list.add(new String(letter));
            return;
        }
        
        if(Character.isLetter(letter[pos]))
        {
            if(Character.isLowerCase(letter[pos]))
            {
                letter[pos] = Character.toUpperCase(letter[pos]);
                backtrack(list, pos+1, letter);
                letter[pos] = Character.toLowerCase(letter[pos]);
            }
            else
            {
                letter[pos] = Character.toLowerCase(letter[pos]);
                backtrack(list, pos+1, letter);
                letter[pos] = Character.toUpperCase(letter[pos]);
            }
               
        }
        backtrack(list, pos+1, letter);
    }
}


