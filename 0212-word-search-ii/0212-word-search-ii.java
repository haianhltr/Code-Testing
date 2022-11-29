class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList();
        TrieNode root = buildTrie(words);
        for(int k = 0; k < board.length; k++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                DFS(board, k,j, root, list);
            }
        }
        return list;
        
    }
    
    public void DFS(char [][] board, int r, int c, TrieNode p, List<String> list)
    {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        char letter = board[r][c];
        if(letter == '#' || p.next[letter - 'a'] == null) return;
        p = p.next[letter-'a'];
        if(p.word != null)
        {
            list.add(p.word);
            p.word = null;
        }
        
        
        board[r][c]  ='#';
        DFS(board, r + 1, c, p, list);
        DFS(board, r - 1, c, p, list);
        DFS(board, r, c + 1, p, list);
        DFS(board, r, c - 1, p, list);
        board[r][c] = letter;
        
        
    }
    
    public TrieNode buildTrie(String [] words)
    {
        TrieNode root = new TrieNode();
        for(String w : words)
        {
            TrieNode temp = root;
            for(char c : w.toCharArray())
            {
                int i = c  - 'a';
                if(temp.next[i] == null) temp.next[i] = new TrieNode();
                temp = temp.next[i];
            }
            temp.word = w;
        }
        return root;
    }
    
    class TrieNode
    {
        TrieNode [] next = new TrieNode[26];
        String word;
    }
}