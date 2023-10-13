package dev.westernpine.datastructures.Custom.Tree;

public class BST {

    public static void main() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(2));
        tree.insert(new Node(0));
        tree.insert(new Node(1));
        tree.insert(new Node(4));
        tree.insert(new Node(3));

        tree.display();

        System.out.println(tree.search(4));
        System.out.println(tree.search(5));

        tree.remove(3);

        System.out.println("InOrderTreeTraversal");
        InOrderTreeTraversal(tree.root);

        System.out.println("PostOrderTreeTraversal");
        PostOrderTreeTraversal(tree.root);

        System.out.println("PreOrderTreeTraversal");
        PreOrderTreeTraversal(tree.root);

    }

    // Navigate a tree in order. Used for removing nodes
    public static void InOrderTreeTraversal(Node node) {
        if(node == null)
            return;

        InOrderTreeTraversal(node.left);
        System.out.println(node.data);
        InOrderTreeTraversal(node.right);
    }

    // Used to delete tree from leaf to root.
    public static void PostOrderTreeTraversal(Node node) {
        if(node == null)
            return;

        InOrderTreeTraversal(node.left);
        InOrderTreeTraversal(node.right);
        System.out.println(node.data);
    }

    // Used to create a copy of a tree
    public static void PreOrderTreeTraversal(Node node) {
        if(node == null)
            return;

        System.out.println(node.data);
        InOrderTreeTraversal(node.left);
        InOrderTreeTraversal(node.right);
    }


}
