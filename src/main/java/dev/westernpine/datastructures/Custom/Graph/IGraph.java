package dev.westernpine.datastructures.Custom.Graph;

public interface IGraph {

    public int size();

    public void addNode(Node node);

    public void addEdge(int source, int dest);

    public boolean hasEdge(int source, int dest);

    public void print();

}
