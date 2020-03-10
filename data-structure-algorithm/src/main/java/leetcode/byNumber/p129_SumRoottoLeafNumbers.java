package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p129_SumRoottoLeafNumbers {


    public int sumNumbers(TreeNode root) {
        getResult(root, 0);
        return sum;
    }

    int sum = 0;

    public void getResult(TreeNode root, int curSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += curSum * 10 + root.val;
            return;
        }
        getResult(root.left, curSum * 10 + root.val);
        getResult(root.right, curSum * 10 + root.val);
    }

    @Test
    public void test() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
//        treeNode1.left = treeNode5;
//        treeNode1.right = treeNode6;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
//        treeNode3.right = treeNode4;
        System.out.println(sumNumbers(treeNode2));
    }
}
