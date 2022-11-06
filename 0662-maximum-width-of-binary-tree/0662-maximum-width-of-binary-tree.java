/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  
    public int widthOfBinaryTree(TreeNode root) {
        
        
      
          return DFS(root, 1, 0, new ArrayList(), new ArrayList());
      
    }
    
    public int DFS(TreeNode root, int width, int level, ArrayList<Integer> start, ArrayList<Integer> end)
    {
        if(root == null) return 0;
        if(level == start.size())
        {
            start.add(width);
            end.add(width);
        }
        else
        {
            end.set(level, width);
        }
    
    int cur = end.get(level) - start.get(level) + 1;
    
    
    int left =  DFS(root.left, 2 * width, level + 1, start, end);
    int right = DFS(root.right, 2 * width + 1, level + 1, start, end);
    
    return Math.max(cur, Math.max(left, right));
    }
}

// start [1,2,4]
// end   [1,2,5]
// return 5 -4 + 1 = 2

