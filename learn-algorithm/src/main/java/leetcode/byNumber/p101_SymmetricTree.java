package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getResult(root.left, root.right);
    }

    public boolean getResult(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return getResult(left.left, right.right) && getResult(left.right, right.left);
    }

    @Test
    public void test() {

    }
}
