package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p104_MaximumDepthofBinaryTree {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    @Test
    public void test() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        System.out.println(maxDepth(treeNode2));
    }
}
