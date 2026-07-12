public class FloorOfBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root;

    public static int findFloor(Node root, int key) {

        int floor = -1;

        while (root != null) {

            if (root.data == key) {
                floor = root.data;
                return floor;
            }

            if (key < root.data) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }

        return floor;
    }

    public static void main(String[] args) {

        root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int key = 5;

        int result = findFloor(root, key);

        if (result != -1) {
            System.out.println("Floor of " + key + " is " + result);
        } else {
            System.out.println("Floor does not exist.");
        }
    }
}