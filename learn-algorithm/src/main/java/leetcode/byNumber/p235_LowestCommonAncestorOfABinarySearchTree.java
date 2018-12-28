package leetcode.byNumber;

import leetcode.base.definition.TreeNode;

public class p235_LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = null;
        TreeNode right = null;
        if (p.val > root.val && q.val > root.val) {
            right = lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            left = lowestCommonAncestor(root.left, p, q);
        } else {
            left = lowestCommonAncestor(root.left, p, q);
            right = lowestCommonAncestor(root.right, p, q);
        }
        return left == null ? right : right == null ? left : root;
    }
}
