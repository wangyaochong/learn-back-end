package leetcode.byNumber;

import leetcode.base.definition.TreeNode;

public class p112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return result(root, sum);
    }

    public boolean result(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return result(root.left, sum - root.val) || result(root.right, sum - root.val);
    }

}
