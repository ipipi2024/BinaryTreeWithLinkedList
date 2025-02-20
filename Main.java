public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        
        // Example usage
        binaryTree.add(5);  // root
        binaryTree.add(3);  // left child
        binaryTree.add(7);  // right child
        binaryTree.add(2);  // left-left child
        binaryTree.add(4);  // left-right child
        binaryTree.add(6);  // right-left child
        
        System.out.println("Tree structure:");
        binaryTree.printTree();
        
        System.out.println("\nTree statistics:");
        System.out.println("Height: " + binaryTree.getHeight());
        System.out.println("Number of nodes: " + binaryTree.getNumberOfNodes());
        System.out.println("Number of leaf nodes: " + binaryTree.getNumberOfLeafNodes());
        System.out.println("Number of internal nodes: " + binaryTree.getNumberOfInternalNodes());
    }
}

class BinaryTree {
    private Node root;
    private int height = 0;
    private int numberOfNodes = 0;
    private int numberOfLeafNodes = 0;
    private int numberOfInternalNodes = 0;

    // Inner Node class
    private static class Node {
        int element;
        Node parent;
        Node leftChild;
        Node rightChild;
        
        Node(int element, Node parent, Node leftChild, Node rightChild) {
            this.element = element;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public void addChild(int n) {
            if (leftChild == null) {
                leftChild = new Node(n, this, null, null);
            } else if (rightChild == null) {
                rightChild = new Node(n, this, null, null);
            } else {
                // Try to add to the shortest subtree
                if (getHeight(leftChild) <= getHeight(rightChild)) {
                    leftChild.addChild(n);
                } else {
                    rightChild.addChild(n);
                }
            }
        }

        // Helper method to get height of a subtree
        private int getHeight(Node node) {
            if (node == null) return -1;
            return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
        }

        // Check if node is a leaf
        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }
    }

    // Public methods
    public void add(int element) {
        if (root == null) {
            root = new Node(element, null, null, null);
            height = 0;
            numberOfLeafNodes = 1;
        } else {
            root.addChild(element);
            updateStats();
        }
        numberOfNodes++;
    }

    // Print tree structure
    public void printTree() {
        printTreeRecursive(root, "", true);
    }

    // Helper method for printing tree using simple ASCII characters
    private void printTreeRecursive(Node node, String prefix, boolean isLeft) {
        if (node == null) return;

        System.out.println(prefix + (isLeft ? "+-- " : "+-- ") + node.element);

        // Build the prefix for children
        String childPrefix = prefix + (isLeft ? "    " : "|   ");

        // Print right child first (will appear at the top)
        printTreeRecursive(node.rightChild, childPrefix, false);
        // Print left child second (will appear at the bottom)
        printTreeRecursive(node.leftChild, childPrefix, true);
    }

    // Update tree statistics
    private void updateStats() {
        height = calculateHeight(root);
        numberOfLeafNodes = countLeafNodes(root);
        numberOfInternalNodes = numberOfNodes - numberOfLeafNodes;
    }

    // Calculate height of the tree
    private int calculateHeight(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(calculateHeight(node.leftChild), calculateHeight(node.rightChild));
    }

    // Count leaf nodes
    private int countLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.isLeaf()) return 1;
        return countLeafNodes(node.leftChild) + countLeafNodes(node.rightChild);
    }

    // Getter methods
    public int getHeight() {
        return height;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getNumberOfLeafNodes() {
        return numberOfLeafNodes;
    }

    public int getNumberOfInternalNodes() {
        return numberOfInternalNodes;
    }
}