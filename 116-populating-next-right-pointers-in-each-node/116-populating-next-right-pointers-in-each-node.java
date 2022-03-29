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
    if (root == null) return root;

    Queue<Node> q = new LinkedList<>();
    int depth = 0;  // current depth level in binary tree
    q.add(root);    // adding root of the binary tree
    while (!q.isEmpty()) {
        Node prev = q.poll();   // take out the left most element of current depth
        // adding their children into the queue
        if (prev.left != null && prev.right != null) {
            q.add(prev.left);
            q.add(prev.right);
        }
        // depth "d" has 2^d number of nodes
        for (int i = 1; i < (1 << depth); i++) {
            Node curr = q.poll();
            prev.next = curr;   // adding next to previous node in current depth level
            prev = curr;        // making current as previous
            // adding children into the queue
            if (prev.left != null && prev.right != null) {
                q.add(prev.left);
                q.add(prev.right);
            }
        }
        // going one level deep
        depth++;
    }
    // returning root of the binary tree
    return root;
}
}