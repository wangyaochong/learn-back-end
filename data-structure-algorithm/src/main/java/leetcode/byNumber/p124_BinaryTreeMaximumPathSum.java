package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p124_BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        getResult(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    public int getResult(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = getResult(node.left);
        int rightMax = getResult(node.right);
        leftMax = leftMax > 0 ? leftMax : 0;
        rightMax = rightMax > 0 ? rightMax : 0;
        if (max < node.val + leftMax + rightMax) {
            max = node.val + leftMax + rightMax;
        }
        return node.val + Math.max(leftMax, rightMax);
    }

    @Test
    public void test() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(-1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
//        treeNode2.right = treeNode3;
        System.out.println(maxPathSum(treeNode2));
    }
}
