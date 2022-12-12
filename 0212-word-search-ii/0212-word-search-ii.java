class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList();
        TrieNode root = new TrieNode();
        root = fillTrie(words);
        for(int k = 0; k < board.length; k++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                DFS(board, words, k, j, root, list);
            }
        }
        
        return list;
    }
    
    public void DFS(char [][] board, String [] words, int row, int column, TrieNode p, List<String> list)
    {
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] == '#' ||  p.next[board[row][column] - 'a'] == null)
            return;
            
     
        char letter = board[row][column];
        p = p.next[letter - 'a'];
        if(p.word != null)
        {
            list.add(p.word);
            p.word = null;
        }
        
               board[row][column] = '#';
        DFS(board, words, row + 1, column, p, list);
         DFS(board, words, row - 1, column, p, list);
         DFS(board, words, row, column + 1, p, list);
         DFS(board, words, row, column - 1, p, list);
        board[row][column] = letter;
        
    }
    
    
    public TrieNode fillTrie(String [] words)
    {
        TrieNode root = new TrieNode();
        for(String word : words)
        {
            TrieNode temp = root;
            for(char c : word.toCharArray())
            {
                int i = c - 'a';
                if(temp.next[i] == null) temp.next[i] = new TrieNode();
                temp = temp.next[i];
                 
            }
            
            temp.word = word;
        }
        return root;
    }
    
    
    public class TrieNode
    {
        TrieNode [] next = new TrieNode[26];
        String word;
    }
}