package structure.tree;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

/**
 * 1
 * 2        5
 * 3   4     6   7
 * 8
 */
public class TraverseTreeRecursion {


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(5, new TreeNode(6, new TreeNode(8, null, null), null), new TreeNode(7, null, null)));

        System.out.println("先序----------------");
        preOrder(treeNode);
        System.out.println("中序--------------");
        inOrder(treeNode);
        System.out.println("后序------------");
        postOrder(treeNode);


    }

    public void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.println(treeNode.getVal());
    }

    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.getLeft());
        System.out.println(treeNode.getVal());
        inOrder(treeNode.getRight());

    }

    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.getVal());
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }


}
