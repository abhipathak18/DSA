public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return mir(root.left, root.right);
    }

    public boolean mir(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null || left.val != right.val)
            return false;

        return mir(left.left, right.right)
                && mir(left.right, right.left);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree obj = new SymmetricTree();
        System.out.println(obj.isSymmetric(root)); // true
    }
}