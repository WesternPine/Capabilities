package dev.westernpine.datastructures.Custom.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphList {

    ArrayList<LinkedList<Node>> aList;

    public GraphList() {
        this.aList = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        aList.add(currentList);

    }

    public void addEdge(int source, int dest) {
        LinkedList<Node> currentList = aList.get(source);
        Node destNode = aList.get(dest).get(0);
        currentList.add(destNode);
    }

    public boolean hasEdge(int source, int dest) {
        LinkedList<Node> currentList = aList.get(source);
        Node destNode = aList.get(dest).get(0);

        for(Node node : currentList) {
            if(node == destNode)
                return true;
        }
        return false;
    }

    public void print() {

        for(LinkedList<Node> inner : aList) {
            for (Node node : inner) {
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }

    }
}
