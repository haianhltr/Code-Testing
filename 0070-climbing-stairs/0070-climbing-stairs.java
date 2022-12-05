class Solution {
    int [] fib;
    public int climbStairs(int n) {
      fib = new int[n+1];
      fib[0] = 1;
      return DFS(n);
        
    }
    public int DFS(int n)
    {
       if(n < 0) return 0;
      
        if(fib[n] != 0)
        {
            return fib[n];
        }
        return fib[n] =  DFS(n-1) + DFS(n -2);
       
    }
}



