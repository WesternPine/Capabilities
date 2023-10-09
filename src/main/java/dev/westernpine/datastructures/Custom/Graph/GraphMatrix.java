package dev.westernpine.datastructures.Custom.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphMatrix {

    List<Node> nodes;
    int[][] matrix;

    public GraphMatrix(int size) {
        nodes = new ArrayList<>();
        this.matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int source, int dest) {
        matrix[source][dest] = 1;
    }

    public boolean hasEdge(int source, int dest) {
        return matrix[source][dest] == 1;
    }

    public void print() {
        System.out.print("  ");
        nodes.forEach(node -> System.out.print(node.data + " "));
        System.out.println();
        for(int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + " ");
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
