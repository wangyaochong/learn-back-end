package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p236_还能这样_问号 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    @Test
    public void test() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        System.out.println(lowestCommonAncestor(a, b, a));
    }
}
