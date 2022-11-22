class Solution {
	public List<String> findWords(char[][] board, String[] words) {
		int rows = board.length, cols = board[0].length;
		Trie trie = new Trie();

		fillTrie(trie, words);                                                                                            // First, we will fill up the Trie with all words.  
		return findWordInBoard(board, trie, rows, cols, new ArrayList<>());                                               // Then, call method to "find Word In Board"
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------- //
	public List<String> findWordInBoard(char[][] board, Trie trie, int rows, int cols, List<String> resultList){
		Trie.TrieNode node;
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){                                                                                 // traverese each char in Board.
				char ch = board[r][c];
				node = trie.root;                                                                                          // we need to reset node each time to root.
				if(node.children[ch - 'a'] == null){ continue; }                                                           // if child exists at children[o - 'a']. children[111-97] = children[14]
				resultList = dfsOnBoard(board, node.children[ch - 'a'], new boolean[rows][cols], r, c, resultList);        // call method, DFS on board 
			}
		}
		return resultList;
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------- //
	public List<String> dfsOnBoard(char[][] board, Trie.TrieNode node, boolean[][] visited, int row, int col, List<String> resultList){
		int rows = board.length, cols = board[0].length;
		if( row < 0   ||   row >= rows   ||  col < 0   ||  col >= cols   ||   
			visited[row][col] == true    ||    board[row][col] != node.val ){
			return resultList;                                                                                             // check bounds, where it returns false   
		}
		if(node!= null && ! node.wordEnd.isEmpty() ){                                                                      // when we reach node in Trie, where we have got a word. 
			if(! node.isDone){                                                                                             // initially isDone = false            
				resultList.add(node.wordEnd);
				node.isDone = true;                                                                                        // once we add this word to resultList, mark isDone = true. 
																											// So, we can avoid duplicate word (in case if same "words" array has duplicate words).
			}
		}
		visited[row][col] = true;
		for(Trie.TrieNode childNode : node.children){
			if(childNode == null){ continue; }
			dfsOnBoard(board, childNode, visited, row, col-1, resultList);                                 // DFS on Left
			dfsOnBoard(board, childNode, visited, row, col+1, resultList);                                 // DFS on Right
			dfsOnBoard(board, childNode, visited, row-1, col, resultList);                                 // DFS on Up
			dfsOnBoard(board, childNode, visited, row+1, col, resultList);                                 // DFS on Down                
		}        
		visited[row][col] = false;
		return resultList;
	}

	// -----------------------------------------------------------------------
	public void fillTrie(Trie trie, String[] words){
		for(String word : words){
			trie.insert(word, trie.root);                                                                                   //  insert each word to Trie
		}
	}


	// ---------------------------------------------------------------------- TRIE ------------------------------------------------------------------------ //
	static class Trie{
		TrieNode root;
		public Trie(){
			root = new TrieNode(' ');
		}

		// ----------------------------------------------------------
		public void insert(String word, TrieNode node){
			for( char ch : word.toCharArray() ){
				node = insertCharInTrie(node, ch);
			}
			node.wordEnd = word;
		}
		public TrieNode insertCharInTrie(TrieNode node, char ch){
			if(node.children[ch - 'a'] == null){
				node.children[ch - 'a'] = new TrieNode(ch);                                
			}
			node = node.children[ch - 'a'];
			return node;
		}

		// ---------------- TRIENODE ----------------------
		static class TrieNode{
			char val;                                                                                       // node's char value e.g. 'o'
			String wordEnd = "";
			boolean isDone = false;
			TrieNode[] children;
			TrieNode(char val){                                                                             // pass val in the constructor 
				this.val = val;
				children = new TrieNode[26];                                                                // each node can have upto 26 children.
			}
		}
	}
}