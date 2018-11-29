package leetcode;

import leetcode.base.TreeNode;
import org.junit.Test;

public class p114_FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        if (root.left != null) {//如果说左边不是null，则需要调整到右边
            TreeNode node = root.left;
            while (node.right != null) {//这个地方会花费更多的遍历时间
                node = node.right;
            }
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }


    @Test
    public void test() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode5;
        treeNode1.right = treeNode6;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        flatten(treeNode2);
        System.out.println(treeNode2);
    }
}
