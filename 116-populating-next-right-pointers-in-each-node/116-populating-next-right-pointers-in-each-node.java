/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size= queue.size();
            Node temp = null;
            for(int k = 0; k < size; k++)
            {    
               Node current = queue.poll();        
               current.next = temp;
               temp = current;
              
                if(current.right != null) queue.add(current.right);
                  if(current.left != null) queue.add(current.left);
            }
        }
        return root;
    }
}