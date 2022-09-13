class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList();
        recur(s.toCharArray(), 0, list);
        return list;
    }
    public void recur(char [] word, int pos, List<String> list)
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
                recur(word, pos+1, list);
                word[pos] = Character.toUpperCase(word[pos]);
            }
            else
            {
                word[pos] = Character.toUpperCase(word[pos]);
                recur(word, pos+1, list);
                word[pos] = Character.toLowerCase(word[pos]);
            }
        }
        recur(word, pos+1, list);
    }
}