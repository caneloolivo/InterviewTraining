package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
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
	
	public Node cloneGraph(Node node) {
		if (node == null) 
			return null;        
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(node);        
        while (!nodes.isEmpty()) {
            Node curr = nodes.poll();
            Node cloned = visited.getOrDefault(curr, new Node(curr.val));
            visited.put(curr, cloned);
            
            for (Node n : curr.neighbors) {
                Node clonedNeighbor = visited.getOrDefault(n, new Node(n.val));
                if (!visited.containsKey(n)) 
                	nodes.offer(n);
                visited.put(n, clonedNeighbor);
                cloned.neighbors.add(clonedNeighbor);
            }
        }
        return visited.get(node);
    }
}
