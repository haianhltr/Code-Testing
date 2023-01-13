class Solution {
    int max = 0;
    int lo = 0;
    public String longestPalindrome(String s) {
        if(s.length()  < 2) return s;
        for(int k = 0; k < s.length() - 1; k++)
        {
            extend(s, k,k);
            extend(s, k, k + 1);
        }

        
        return s.substring(lo, lo  + max);
    }
    
    public void extend(String s, int left, int right)
    {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
        
            left--;
            right++;
        }
        
        if(right - left  - 1 > max)
        {
            lo = left + 1;
            max = right - left - 1;
        }
    }
}

