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
        HashMap<Node,Node> hash = new HashMap();
        return DFS(node, hash);
    }
    private Node DFS(Node node, HashMap<Node,Node> hash)
    {
        if(hash.containsKey(node))
        {
           return hash.get(node);
        }
        hash.put(node,new Node(node.val));
        
        
        for(Node neighbor : node.neighbors)
        {
            hash.get(node).neighbors.add(DFS(neighbor,hash));
        }
        
        return hash.get(node);
    }
}