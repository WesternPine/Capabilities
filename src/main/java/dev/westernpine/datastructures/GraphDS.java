package dev.westernpine.datastructures;

import dev.westernpine.datastructures.Custom.Graph.GraphList;
import dev.westernpine.datastructures.Custom.Graph.GraphMatrix;
import dev.westernpine.datastructures.Custom.Graph.Node;

public class GraphDS {

    /*
     * Non-linear aggregation of Nodes (Vertexes) and Edges.
     * There are two types of graphs: undirected, and directed.
     *
     * Undirected: Facebook social group.
     * Directed: Warehouse conveyor system.
     *
     * Adjacency: sharing a bond
     *
     * Two ways to represent a graph:
     *
     * Adjacency matrix
     * Adjacency list
     *
     * Matrix: (2D array(list))
     *   A B C
     * A 0 1 1
     * B 1 0 0
     * C 0 1 0
     * The above matrix indicates that theres an edge from A to B and C, from B to A, and from C to B
     * The Time complexity for finding an edge is O(1)
     * But the space complexity of this is O(n^2)
     *
     * List:
     * A -> B,C
     * B -> A
     * C -> B
     * The time complexity for lists is O(n), since it will need to possibly navigate through all values.
     * The space complexity is O(n+p) where p is the number of edges. This is more effecient on space.
     */

    public static void main() {

        GraphMatrix graphMatrix = new GraphMatrix(5); // Matrix-based graph!

        graphMatrix.addNode(new Node('0'));
        graphMatrix.addNode(new Node('1'));
        graphMatrix.addNode(new Node('2'));
        graphMatrix.addNode(new Node('3'));
        graphMatrix.addNode(new Node('4'));

        graphMatrix.addEdge(0, 1);
        graphMatrix.addEdge(1, 2);
        graphMatrix.addEdge(2, 3);
        graphMatrix.addEdge(2, 4);
        graphMatrix.addEdge(4, 0);
        graphMatrix.addEdge(4, 2);

        //graphMatrix.print();

        assert graphMatrix.hasEdge(0, 1);


        // LIST


        GraphList graphList = new GraphList();

        graphList.addNode(new Node('0'));
        graphList.addNode(new Node('1'));
        graphList.addNode(new Node('2'));
        graphList.addNode(new Node('3'));
        graphList.addNode(new Node('4'));

        graphList.addEdge(0, 1);
        graphList.addEdge(1, 2);
        graphList.addEdge(2, 3);
        graphList.addEdge(2, 4);
        graphList.addEdge(4, 0);
        graphList.addEdge(4, 2);

        //graphList.print();

        assert graphList.hasEdge(0, 1);



    }

}
