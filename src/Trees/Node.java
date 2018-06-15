package src.Trees;

public class Node {
    int data;
    Node right;
    Node left;
    int index;

    public Node(int data) {
        this.data = data;
        left = right = null;
        index = 0;
    }
}
