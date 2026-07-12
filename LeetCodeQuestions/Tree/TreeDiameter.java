class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

}

public class TreeDiameter {

    private int maxi = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxi;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Update the maximum diameter
        maxi = Math.max(maxi, leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Driver Code
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5

            Diameter = 3
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeDiameter tree = new TreeDiameter();

        System.out.println("Diameter of Binary Tree: " +
                tree.diameterOfBinaryTree(root));
    }
}