/**
 *
 * Sample codes for graph algorithm
 *
 **/

import java.util.*;

enum State {
    UNVISITED, VISITING, VISITED;
}

class GraphNode {
    int data;
    private ArrayList<GraphNode> neighbors;
    State state;

    GraphNode(int data) {
        this.data = data;
        this.neighbors = new ArrayList<GraphNode>();
        this.state = State.UNVISITED;
    }

    ArrayList<GraphNode> getNeighbors() {
        return this.neighbors;
    }

    GraphNode addNeighbor(GraphNode node){
        this.neighbors.add(node);
        return node;
    }
}


public class Graph {

    public ArrayList<GraphNode> nodes;

    public Graph() {
        this.nodes = new ArrayList<GraphNode>();
    }

    public void setUnvisited() {
        for (GraphNode node: nodes) {
            if (node != null)
                node.state = State.UNVISITED;
        }
    }

    public void addEdge(int n1, int n2) throws IllegalArgumentException {
        if (n1 < 0 || n2 < 0 || n1 >= this.nodes.size() || 
            n2 >= this.nodes.size()) {
            throw new IllegalArgumentException("Nodes not found");
        }
        this.nodes.get(n1).addNeighbor(this.nodes.get(n2));
    }

    public static boolean bfsPathExist(GraphNode start, GraphNode end) {
        if (start == null)
            return false;

        if (start == end)
            return true;

        Queue<GraphNode> q = new LinkedList<GraphNode>();
        start.state = State.VISITING;
        q.add(start);

        while (!q.isEmpty()) {
            GraphNode next = q.poll();
            if (next != null) {
                if (next == end)
                    return true;
                for (GraphNode neighbor: next.getNeighbors()) {
                    if (neighbor.state == State.UNVISITED) {
                        neighbor.state = State.VISITING;
                        q.add(neighbor);
                    }
                }
                next.state = State.VISITED;
            }
        }
        return false;
    }

    public static boolean dfsPathExist(GraphNode start, GraphNode end) {
        
        if (start == null)
            return false;
        
        if (start == end)
            return true;

        for (GraphNode neighbor: start.getNeighbors()) {
            if (neighbor != null && neighbor.state == State.UNVISITED &&
                dfsPathExist(neighbor, end)) {
                return true;
            }
        }
        start.state = State.VISITED;
        return false;
    }

    public static void main(String []args) {

        // Start node is null
        Graph graph = new Graph();
        GraphNode start = null;
        GraphNode end = new GraphNode(1);
        
        graph.nodes.add(start);
        graph.nodes.add(end);

        System.out.print(graph.bfsPathExist(start, end) ? "bfsYES ": "bfsNO ");
        graph.setUnvisited();
        System.out.println(graph.dfsPathExist(start, end) ? "dfsYES": "dfsNO");


        // 0->1 graph
        graph = new Graph();
        graph.nodes.add(new GraphNode(0));
        graph.nodes.add(new GraphNode(1));
        graph.addEdge(0, 1);
        start = graph.nodes.get(0);
        end = graph.nodes.get(1);
        System.out.print(graph.bfsPathExist(start, end) ? "bfsYES ": "bfsNO ");
        graph.setUnvisited();
        System.out.println(graph.dfsPathExist(start, end) ? "dfsYES": "dfsNO");


        // 0->1 0->2->3
        // test 2->3
        graph = new Graph();
        graph.nodes.add(new GraphNode(0));
        graph.nodes.add(new GraphNode(1));
        graph.nodes.add(new GraphNode(2));
        graph.nodes.add(new GraphNode(3));

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        start = graph.nodes.get(2);
        end = graph.nodes.get(3);

        System.out.print(graph.bfsPathExist(start, end) ? "bfsYES ": "bfsNO ");
        graph.setUnvisited();
        System.out.println(graph.dfsPathExist(start, end) ? "dfsYES": "dfsNO");

        // 0->1 0->2->3
        // test 2->0
        start = graph.nodes.get(2);
        end = graph.nodes.get(0);
        graph.setUnvisited();
        System.out.print(graph.bfsPathExist(start, end) ? "bfsYES ": "bfsNO ");
        graph.setUnvisited();
        System.out.println(graph.dfsPathExist(start, end) ? "dfsYES": "dfsNO");
    }
}