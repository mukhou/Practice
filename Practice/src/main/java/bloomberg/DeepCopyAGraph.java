package bloomberg;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/2/18
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
import dataStructures.Node;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyAGraph {
    /*List<Node> nodes;
    public Graph deepCopy () {
        Graph g = new Graph();
        g.nodes = new ArrayList<>();
        Map<Node, Node> isomorphism = new IdentityHashMap<>();
        for (Node n : nodes) {
            g.nodes.add(n.deepCopy(isomorphism));
        }
        return g;
    }

    // in Node
    public Node deepCopy(Map<Node, Node> isomorphism) {
        Node copy = isomorphism.get(this);
        if (copy == null) {
            copy = new Node();
            isomorphism.put(this, copy);
            for (Node connection: connections) {
                copy.connections.add(connection.deepCopy(isomorphism));
            }
        }
        return copy;
    }
*/}
