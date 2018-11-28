package leetcode;

import leetcode.base.TreeNode;
import org.junit.Test;

public class p98_ValidateBinarySearchTree_简单版本 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode treeNode, long min, long max) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.val <= min || treeNode.val >= max) {
            return false;
        }
        return isValid(treeNode.left, min, treeNode.val) && isValid(treeNode.right, treeNode.val, max);
    }

    @Test
    public void test() {
        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode2.left = treeNode1;
//        treeNode2.right = treeNode3;
        System.out.println(isValidBST(treeNode2));
    }
}
