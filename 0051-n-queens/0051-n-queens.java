class Solution {
  public List<List<String>> solveNQueens(int N) {
	List<List<String>> list = new ArrayList<List<String>>();
	if(N<1) return list;
	char[][] board = new char[N][N];
	  
      //fill
      for(int k = 0; k < board.length; k++)
      {
          for(int j = 0; j < board[0].length; j++)
          {
              board[k][j] = '.';
          }
      }
      
	solve(board, N, 0, list);
	return list;
}
private boolean solve(char[][] board, int N, int count, List<List<String>> list) {
	if(count==N) { // done soving, simply add the board into the result
		List<String> temp = new ArrayList<String>();
        for(int i = 0; i < N; i++) {
            temp.add(String.valueOf(board[i]));
        }
		list.add(temp);
		return false; // return false so will backtrack
	}
    
    
    
	for(int i=0; i<N; i++) {
		if(isValid(board, N, i, count)) {
			board[i][count] = 'Q'; // greedy
			if(solve(board, N, count+1, list)) return true;
			else board[i][count] = '.'; // backtrack
		}
	}
	return false;
}
    
    
private boolean isValid(char[][] board, int N, int row, int col) {
	for(int i=0; i<N; i++) {
		if(board[i][col]!='.') return false;
		if(board[row][i]!='.') return false;
	}
	int step = 1;
    //negative diagnal
	while(row - step >=0 && col - step>=0)
		if(board[row-step][col-step++]!='.') return false;
	step = 1;
	while(row + step <N && col -step>=0)
		if(board[row+step][col-step++]!='.') return false;
	return true;
}
}