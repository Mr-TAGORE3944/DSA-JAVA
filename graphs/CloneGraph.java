package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// import LinkedList.Implementation_of_LinkedList.Node;

public class CloneGraph {
    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null)
                return null;

            Map<Node, Node> map = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();

            queue.add(node);
            map.put(node, new Node(node.val));

            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                for (Node neighbor : curr.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new Node(neighbor.val));
                        queue.add(neighbor);
                    }
                    map.get(curr).neighbors.add(map.get(neighbor));
                }
            }

            return map.get(node);
        }
    }

}
