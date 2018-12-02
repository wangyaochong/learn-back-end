package leetcode.byNumber;

import leetcode.base.definition.TreeNode;

public class p111_MinimumDepthofBinaryTree {

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getResult(root, 1);
        return minDepth;
    }


    public void getResult(TreeNode root, int currentLevel) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (currentLevel < minDepth) {
                minDepth = currentLevel;
            }
            return;
        }
        getResult(root.left, currentLevel + 1);
        getResult(root.right, currentLevel + 1);
    }
}
