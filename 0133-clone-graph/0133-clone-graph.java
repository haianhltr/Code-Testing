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
    HashMap<Node, Node> hash = new HashMap();
    public Node cloneGraph(Node node) {
        if(node ==null) return null;
        if(!hash.containsKey(node))
        {
            hash.put(node, new Node(node.val));
        }
        else
        {
            return hash.get(node);
        }
        
        for(Node nei : node.neighbors)
        {
            hash.get(node).neighbors.add(cloneGraph(nei));
        }
            
        return hash.get(node);
    }
}