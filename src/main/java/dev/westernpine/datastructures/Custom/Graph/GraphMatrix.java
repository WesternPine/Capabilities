package dev.westernpine.datastructures.Custom.Graph;

import java.util.*;

public class GraphMatrix implements IGraph {

    List<Node> nodes;
    int[][] matrix;

    public GraphMatrix(int size) {
        nodes = new ArrayList<>();
        this.matrix = new int[size][size];
    }

    public int size() {
        return this.matrix.length;
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

    public Queue<Integer> breadthFirstSearch(int from, int to) {
        Queue<Integer> visitedNodes = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(from);
        visited[from] = true;
        while(queue.size() != 0) {
            visitedNodes.offer(from = queue.poll());
            for(int i = 0; i < matrix[from].length; i++) {
                if(!visited[i] && matrix[from][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return visitedNodes;
    }


    public Collection<LinkedList<Node>> depthFirstSearch(int from, int to) {
        boolean[] visited = new boolean[matrix.length];

        Collection<LinkedList<Node>> paths = depthSearch(from, to, visited);
        paths.forEach(path -> path.push(nodes.get(from)));

        return paths;
    }

    // This function is modified from the tutorial. I wanted to provide back all possible paths.
    private Collection<LinkedList<Node>> depthSearch(int from, int to, boolean[] visited) {
        // Base Case
        if(visited[from])
            return new ArrayList<>();

        visited[from] = true;

        Collection<LinkedList<Node>> knownPaths = new ArrayList<>();
        int[] nextNodes = matrix[from];
        for(int i = 0; i < nextNodes.length; i++) {
            if(nextNodes[i] == 1) {
                if(i == to) {
                    ArrayList<LinkedList<Node>> paths = new ArrayList<>();
                    LinkedList<Node> nodeList = new LinkedList<>();
                    nodeList.add(nodes.get(to));
                    paths.add(nodeList);
                    return paths;
                }

                // Performing a copy of the array allows me to find all possible solutions from the source,
                // which could allow me to pass through the same node twice to find the shortest route.
                Collection<LinkedList<Node>> paths = depthSearch(i, to, Arrays.copyOf(visited, matrix.length));
                int finalI = i;
                paths.forEach(path -> path.push(nodes.get(finalI)));
                knownPaths.addAll(paths);
            }
        }

        return knownPaths;
    }

}
