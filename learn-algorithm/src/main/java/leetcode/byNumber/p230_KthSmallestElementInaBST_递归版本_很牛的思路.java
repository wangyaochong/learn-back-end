package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class p230_KthSmallestElementInaBST_递归版本_很牛的思路 {

    @Test
    public void testKthSmallest() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode1.right = treeNode2;
        int i = kthSmallest(treeNode3, 3);
        System.out.println(i);
    }

    int c = 0;

    public int kthSmallest(TreeNode root, int k) {
        int val;
        if (root.left != null) {
            val = kthSmallest(root.left, k);
            if (k == c) return val;
        }
        c++;
        if (k == c) {
            return root.val;
        }
        if (root.right != null) {
            val = kthSmallest(root.right, k);
            if (k == c) return val;
        }
        return root.val;
    }
}
