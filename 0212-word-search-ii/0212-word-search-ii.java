class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int rows= board.length;
        int columns = board[0].length;
        //implement Trie
        Trie trie = new Trie();
        fillTrie(trie, words);
        return findWord(board, trie, rows, columns, new ArrayList());
    }
    
    public List<String> findWord(char [][] board, Trie trie, int rows, int cols, List<String> list)
    {
            Trie.TrieNode node;
            for(int k = 0; k < rows; k++)
            {
                for(int j = 0; j < cols; j++)
                {
                    char ch = board[k][j];
                    node = trie.root;
                    if(node.children[ch - 'a'] == null) continue;
                    list = DFS(board, node.children[ch - 'a'], new boolean[rows][cols],k, j, list);
                }
            }
        return list;
    }
    
    
    public List<String> DFS(char [][] board, Trie.TrieNode node, boolean [][] visited, int row, int column, List<String> list)
    {
        int rows = board.length;
        int columns = board[0].length;
        if(row < 0 || row >= rows || column < 0 || column >= columns || visited[row][column] == true|| board[row][column] != node.val)
        {
            return list;
        }
        
        if(node != null && !node.wordEnd.isEmpty())
        {
            if(!node.isDone)
            {
                list.add(node.wordEnd);
                node.isDone = true;
            }
        }
        
        visited[row][column] = true;
        for(Trie.TrieNode childNode : node.children)
        {
            if(childNode == null) continue;
            DFS(board, childNode, visited, row + 1, column, list);
            DFS(board, childNode, visited, row - 1, column, list);
            DFS(board, childNode, visited, row, column + 1, list);
            DFS(board, childNode, visited, row, column - 1, list);
            
        }
        
        visited[row][column] = false;
        return list;
    }
    
    
    public void fillTrie(Trie trie, String [] words)
    {
        for(String word : words)
        {
            trie.insert(word, trie.root);
        }
    }
    
    static class Trie{
        TrieNode root;
        public Trie()
        {
            root = new TrieNode(' ');
        }
        
        public void insert(String word, TrieNode node)
        {
            for(char ch : word.toCharArray())
            {
                node = insertCharInTrie(node, ch);
            }
            node.wordEnd = word;
        }
        
        public TrieNode insertCharInTrie(TrieNode node, char ch)
        {
            if(node.children[ch - 'a'] == null)
            {
                node.children[ch - 'a'] = new TrieNode(ch);
            }
            node = node.children[ch - 'a'];
            return node;
        }
    
    
    static class TrieNode{
        char val;
        String wordEnd ="";
        boolean isDone = false;
        TrieNode [] children;
        TrieNode(char val)
        {
            this.val = val;
            children = new TrieNode[26];
        }
    }
    
    
}
}