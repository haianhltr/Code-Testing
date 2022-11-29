class Solution {
    int count  =0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        DFS(root, targetSum, 0);
        
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }
    
    public void DFS(TreeNode root, int targetSum, long sum)
    {
        if(root == null) return;
        sum += root.val;
        if(sum == targetSum)
        {
            count++;
        }
        DFS(root.left, targetSum, sum);
        DFS(root.right, targetSum, sum);
    }
}