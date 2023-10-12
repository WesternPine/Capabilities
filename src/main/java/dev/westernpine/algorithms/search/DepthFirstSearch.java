package dev.westernpine.algorithms.search;

import dev.westernpine.datastructures.Custom.Graph.GraphMatrix;
import dev.westernpine.datastructures.Custom.Graph.IGraph;
import dev.westernpine.datastructures.Custom.Graph.Node;

public class DepthFirstSearch {

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

        graphMatrix.depthFirstSearch(4, 3);
    }

}
