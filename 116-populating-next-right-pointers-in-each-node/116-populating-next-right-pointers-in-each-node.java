///DFS
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            //create a node max to store the right-most node
            Node max = new Node(0);
            int size = queue.size();
            for(int k = 0; k  <size ; k++)
            {
                
                Node temp = queue.poll();
                //since we starte from the right, the 
                if(k==0){
                    temp.next = null;
                    max = temp;
                    }
                else{
                    temp.next = max;
                    max = temp;
                }
                if(temp.right != null) queue.add(temp.right);
                if(temp.left != null) queue.add(temp.left);
            }        
        }
        return root;
    }
}
