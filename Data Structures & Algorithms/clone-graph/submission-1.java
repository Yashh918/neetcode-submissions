/*
Definition for a Node.
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
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        dfs(node);
        return map.get(node);
    }

    public void dfs(Node node) {
        Node cloneNode = map.getOrDefault(node, new Node(node.val));
        map.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                Node cloneNeighbor = map.get(neighbor);
                if (!cloneNeighbor.neighbors.contains(cloneNode)) {
                    cloneNode.neighbors.add(cloneNeighbor);
                    cloneNeighbor.neighbors.add(cloneNode);
                }
                continue;
            }

            Node cloneNeighbor = new Node(neighbor.val);
            map.put(neighbor, cloneNeighbor);
            cloneNode.neighbors.add(cloneNeighbor);
            cloneNeighbor.neighbors.add(cloneNode);
            dfs(neighbor);
        }
    }
}