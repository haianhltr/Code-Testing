class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        backtrack(s.toCharArray(), 0, list);
        return list;
    }
    
    public void backtrack(char [] word, int pos, List<String> list)
    {
        list.add(new String(word));
        for(int k = pos; k < word.length; k++)
        {
            if(Character.isLetter(word[k]))
            {
                if(Character.isUpperCase(word[k])){
                    word[k] = Character.toLowerCase(word[k]);
                    backtrack(word, k+1, list);
                    word[k] = Character.toUpperCase(word[k]);
                }else{
                word[k] = Character.toUpperCase(word[k]);
               backtrack(word, k+1, list);
               word[k] = Character.toLowerCase(word[k]);
            }}
        }
    }
}