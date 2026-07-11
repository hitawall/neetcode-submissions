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
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
            
        Set<Node> vis = new HashSet<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);

        while(!q.isEmpty())
        {
            Node currNode = q.poll();
            if(currNode==null || vis.contains(currNode))
                continue;
            
            Node newNode = null;
            if(nodeMap.containsKey(currNode.val))
            {
                newNode = nodeMap.get(currNode.val);
            }
            else
            {
                newNode = new Node(currNode.val);
                nodeMap.put(currNode.val, newNode);
            }
            

            vis.add(currNode);

            List<Node> n = currNode.neighbors;

            for(Node itr: n)
            {
                q.add(itr);
                if(nodeMap.containsKey(itr.val))
                {
                    newNode.neighbors.add(nodeMap.get(itr.val));
                }
                else
                {
                    Node anotherNode = new Node(itr.val);
                    newNode.neighbors.add(anotherNode);
                    nodeMap.put(itr.val, anotherNode);
                }

            }
            vis.add(currNode);
        }

        return nodeMap.get(node.val);

    }
}