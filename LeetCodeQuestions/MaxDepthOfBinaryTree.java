// 1. Keep the TreeNode definition at the top
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// 2. Keep your original solution class
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

// 3. CRITICAL: The class name MUST match your filename exactly
public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        // Manually build Example 1: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Instantiate and test your solution
        Solution solver = new Solution();
        int result = solver.maxDepth(root);

        // Print output to terminal
        System.out.println("Maximum Depth: " + result); 
    }
}
