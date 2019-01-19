package apimodels;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA){
        nodes.add(nodeA);
    }

    //region Getter
    public Set<Node> getNodes() {
        return nodes;
    }

    //endregion

    public Node getNodeByName(String name){

        Node resultNode = new Node("");

        for(Node n : nodes){
            if(n.getName().equals(name))
                resultNode = n;

        }

        return resultNode;
    }
}
