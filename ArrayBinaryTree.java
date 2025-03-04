import java.util.ArrayList;

public class ArrayBinaryTree {
    int numberOfNodes;
    ArrayList<Integer> arr = new ArrayList<>();

    ArrayBinaryTree() {}

    //adding elements to binary tree from left to right
    public void addChild(int num) {
        arr.add(num);  
    }

    public ArrayList<Integer> getChildren(int num) {
        ArrayList<Integer> children = new ArrayList<>(2);
        
        // Find the index of the parent
        int indexOfParent = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == num) {
                indexOfParent = i;
                break;
            }
        }
        
        // If parent not found
        if (indexOfParent == -1) {
            return children;
        }
        
        // Calculate children indices
        int leftChildIndex = (2 * indexOfParent) + 1;
        int rightChildIndex = (2 * indexOfParent) + 2;
        
        // Add children if they exist
        if (leftChildIndex < arr.size()) {
            children.add(arr.get(leftChildIndex));
        }
        
        if (rightChildIndex < arr.size()) {
            children.add(arr.get(rightChildIndex));
        }
        
        return children;
    }


    //print binary tree
    public void printBinaryTree() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }


}
