package structure.tree;

import leetcode.base.definition.TreeNode;
import org.junit.Test;


/**
 * 线索二叉树
 */
public class ThreadTree {

    TreeNode pre = null;

    public void visitThreadTree(TreeNode treeNode) {
        while (treeNode != null) {
            while (!treeNode.isLeftIndex()) {
                treeNode = treeNode.left;
            }
            System.out.println(treeNode.val);
            while (treeNode.isRightIndex()) {
                treeNode = treeNode.right;
                System.out.println(treeNode.val);
            }
            treeNode = treeNode.getRight();
        }
    }

    public void makeThread(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        makeThread(treeNode.left);
        if (treeNode.left == null) {
            treeNode.left = pre;
            treeNode.setLeftIndex(true);
        }
        if (pre != null && pre.right == null) {
            pre.right = treeNode;
            pre.setRightIndex(true);
        }
        pre = treeNode;
        makeThread(treeNode.right);
    }

    /**
     * --------1
     * ---2        5
     * 3    4     6   7
     * ----------8
     */
    @Test
    public void test() {
//        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(4, null, null));
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(5, new TreeNode(6, new TreeNode(8, null, null), null), new TreeNode(7, null, null)));

        makeThread(treeNode);
        visitThreadTree(treeNode);
        System.out.println("----------------------");
        new TraverseTreeRecursion().inOrder(treeNode);
    }
}
