class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList();
        if(digits.length() == 0) return list;
        String [] key = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
        backtrack(list, digits, key, new StringBuilder(), 0);
        return list;
    }
    
    public void backtrack(List<String> list, String digits, String [] key, StringBuilder temp, int pos)
    {
        if(temp.length() == digits.length())
        {
            list.add(temp.toString());
            return;
        }
        
   
        
        for(int k = pos; k < digits.length(); k++)
        {
            int number =  Character.getNumericValue(digits.charAt(k));
            String letter = key[number -2];
                for(int i = 0; i < letter.length(); i++){
                   
                temp.append(letter.charAt(i));
                backtrack(list, digits, key, temp, k +1);
                temp.deleteCharAt(temp.length()-1);
            }}}}
    

