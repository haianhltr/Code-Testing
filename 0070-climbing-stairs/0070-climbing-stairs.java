class Solution {
    int [] fib = new int[10000];
    public int climbStairs(int n) {
      fib[0] = 1;
      fib[1] = 1;
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
        fib[n] = climbStairs(n-1) + climbStairs(n -2);
        return fib[n];
    }
}



