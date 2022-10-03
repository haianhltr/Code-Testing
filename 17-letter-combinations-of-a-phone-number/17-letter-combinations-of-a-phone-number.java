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
        
       int number =  digits.charAt(pos) - '0';
       String letter = key[number -2];
        
        for(int k = 0; k < letter.length(); k++)
        {
                temp.append(letter.charAt(k));
               
                backtrack(list, digits, key, temp, pos +1);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

