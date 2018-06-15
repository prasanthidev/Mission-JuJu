package src.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees {
    static int height = 1;
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(12);
        root.right = new Node(13);
        root.left.right = new Node(14);
        root.left.right.left = new Node(15);
        root.left.right.left.right = new Node(16);
        root.right.left = new Node(17);
        root.right.left.right = new Node(18);
        root.right.left.right.right = new Node(20);

        System.out.println("\n ==== LEFT VIEW ====");
        printLeftView(root);
        System.out.println("\n ==== RIGHT VIEW ====");
        printRightView(root);
        System.out.println("\n   -- INDEX --   ");
        findIndexOfEveryNode(root, root.index, height);
        System.out.println("\n ==== TOP VIEW ====");
        printTopView(root);
        System.out.println("\n ==== BOTTOM VIEW ====");
        printBottomView(root);
    }

    public static void printLeftView(Node root) {
        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        int height = 5;
        while(height-- > 0) {
             int count = stack.size();
             Node leftView = stack.peek();
             System.out.print(leftView.data + " ");
             while(count-- > 0){
                 Node temp = stack.remove();
                 if(temp.left != null && stack.add(temp.left));
                 if(temp.right != null && stack.add(temp.right));
             }
        }
    }

    public static void printRightView(Node root) {
        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        int height = 5;
        while(height-- > 0) {
            int count = stack.size();
            Node leftView = stack.peek();
            System.out.print(leftView.data + " ");
            while(count-- > 0){
                Node temp = stack.remove();
                if(temp.right != null && stack.add(temp.right));
                if(temp.left != null && stack.add(temp.left));
            }
        }
    }

    public static void printTopView(Node root) {
        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        int minIndex = 1, maxIndex = -1;
        int height = BinaryTrees.height;

        while(height-- > 0) {
            int count = stack.size();
            while(count-- > 0){
                Node temp = stack.remove();
                if(temp.left != null && stack.add(temp.left));
                if(temp.right != null && stack.add(temp.right));
                if(temp.index > maxIndex) {
                    System.out.print(temp.data + " ");
                    maxIndex++;
                } else if(temp.index < minIndex) {
                    System.out.print(temp.data + " ");
                    minIndex = -1 - minIndex;
                }
            }
        }
    }

    private static void findIndexOfEveryNode(Node root, int index, int height) {
        if(root == null) {
            return;
        }

        findIndexOfEveryNode(root.left, index - 1, height + 1);
        root.index = index;
        if(height > BinaryTrees.height) {
            BinaryTrees.height = height;
        }
        System.out.print(root.data + "(" + root.index + ", " + height + "), ");
        findIndexOfEveryNode(root.right, index + 1, height + 1);
    }

    public static void printBottomView(Node root) {
        HashMap<Integer, Integer> listOfnodesAtIndex = new HashMap<>();
        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        int height = BinaryTrees.height;

        while(height-- > 0) {
            int count = stack.size();
            while(count-- > 0){
                Node temp = stack.remove();
                listOfnodesAtIndex.put(temp.index, temp.data);
                if(temp.right != null && stack.add(temp.right));
                if(temp.left != null && stack.add(temp.left));
            }
        }

        System.out.println(listOfnodesAtIndex.values());
    }

}

