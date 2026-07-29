
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class CountNodesEqualToAverageOfSubtree {

    private int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // Returns {sum, count}
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == node.val) {
            ans++;
        }

        return new int[]{sum, count};
    }

    public static void main(String[] args) {

        /*
                 4
                / \
               8   5
              / \   \
             0   1   6

            Output: 5
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
        CountNodesEqualToAverageOfSubtree obj =
                new CountNodesEqualToAverageOfSubtree();

        System.out.println("Count = " + obj.averageOfSubtree(root));
    }
}