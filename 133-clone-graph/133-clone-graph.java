/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> hash = new HashMap();
        hash.put(node, new Node(node.val));
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while(!queue.isEmpty())
        {
            Node current = queue.poll();
            for(Node n : current.neighbors)
            {
                if(!hash.containsKey(n))
                {
                    hash.put(n, new Node(n.val));
                    queue.add(n);
                }
                hash.get(current).neighbors.add(hash.get(n));
            }
        }
        return hash.get(node);
    }
}