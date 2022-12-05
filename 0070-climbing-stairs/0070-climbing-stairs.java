class Solution {
    int [] fib;
    public int climbStairs(int n) {
      fib = new int[n+1];
      fib[0] = 1;
      return DFS(n);
        
    }
    public int DFS(int n)
    {
        if(n == 0) return 1;
        if(n == 1) return 1;
      
        if(fib[n] != 0)
        {
            return fib[n];
        }
        fib[n] =  DFS(n-1) + DFS(n -2);
        return fib[n];
       
    }
}



