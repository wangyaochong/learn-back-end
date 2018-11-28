package leetcode;

import leetcode.base.TreeNode;
import org.junit.Test;

public class p110_BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHeight = 1 + getHeight(treeNode.left);
        if (leftHeight < 0) {
            return Integer.MIN_VALUE;
        }
        int rightHeight = 1 + getHeight(treeNode.right);
        if (rightHeight < 0 || leftHeight - rightHeight < -1 || leftHeight - rightHeight > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight);
    }


    @Test
    public void test() {

    }
}
