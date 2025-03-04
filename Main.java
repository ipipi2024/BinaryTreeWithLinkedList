import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree();
        arrayBinaryTree.addChild(0);
        arrayBinaryTree.addChild(1);
        arrayBinaryTree.addChild(2);
        arrayBinaryTree.addChild(3);
        arrayBinaryTree.addChild(4);
        arrayBinaryTree.addChild(5);
        arrayBinaryTree.addChild(6);
        arrayBinaryTree.printBinaryTree();
        
        ArrayList<Integer> children = arrayBinaryTree.getChildren(4); // Choose a node that has children
        System.out.println();
        
        // Check if children exist before accessing them
        if (children.size() > 0) {
            System.out.println("Left Child: " + children.get(0));
        } else {
            System.out.println("No left child found");
        }
        
        if (children.size() > 1) {
            System.out.println("Right Child: " + children.get(1));
        } else {
            System.out.println("No right child found");
        }
    }
}