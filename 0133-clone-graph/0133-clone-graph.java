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
       Queue<Node> q = new LinkedList<>();
       HashMap<Node,Node> map = new HashMap<>();
       if(node== null)return null;
       Node clone = new Node(node.val);
       q.add(node);
       map.put(node, clone);
       while(!q.isEmpty()){
        Node curr = q.poll();
        for(int i =0; i<curr.neighbors.size(); i++){
            Node neig = curr.neighbors.get(i);
            if(!map.containsKey(neig)){
                map.put(neig, new Node(neig.val));
                q.offer(neig);
            }
            map.get(curr).neighbors.add(map.get(neig));
        }
       }
       return clone;
    }
}