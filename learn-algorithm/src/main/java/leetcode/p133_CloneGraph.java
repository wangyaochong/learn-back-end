package leetcode;

import leetcode.base.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p133_CloneGraph {


    Map<Integer, UndirectedGraphNode> cache = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        cache.put(copy.label, copy);
        copy.neighbors = new ArrayList<>();
        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode undirectedGraphNode = cache.get(neighbor.label);
            if (undirectedGraphNode != null) {
                copy.neighbors.add(undirectedGraphNode);
            } else {
                copy.neighbors.add(cloneGraph(neighbor));
            }
        }
        return copy;
    }
}
