package dev.westernpine.datastructures.Custom.Tree;

public class BinarySearchTree {

    public Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;
        if(root == null) {
            root = node;
            return root;
        }

        if(data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if(root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {

        if(root == null) {
            return false;
        }

        if(root.data == data) {
            return true;
        }

        if(root.data > data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data) {

        if(!search(data)) {
            return;
        }

        removeHelper(root, data);

    }

    private Node removeHelper(Node root, int data) {

        if(root == null) {
            return root;
        }

        if(data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else { // Above checks are just navigating to the node. Here if it isn't less than, and it isn't greater than, then we have found our node.

            if(root.left == null && root.right == null) { // We are a leaf node!
                root = null;
            } else if (root.right != null) { // We have a right node
                root.data = successor(root); // Go off on all left children of the root's right child to find the lease value, and reassign it to this value.
                root.right = removeHelper(root.right, root.data); // Remove the last child, and reassign all child nodes up the chain to this point.
            } else { // We have a right node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }

        }

        return root; // This is something the tutorial actually left out.
        // When we reassign the root node, we were still returning null, which actually delete the whole side of the tree.
        // We just needed to return the root.
    }

    private int successor(Node root) { // Find the least value below right child of this root node.
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) { // Find the greatest value below left child of this root node.
        root = root.left;
        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }

}
