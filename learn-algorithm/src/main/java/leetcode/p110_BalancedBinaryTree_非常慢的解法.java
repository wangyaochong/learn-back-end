package leetcode;

import leetcode.base.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p110_BalancedBinaryTree_非常慢的解法 {
    class XY {
        public int left;
        public int right;

        public XY(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        XY xy = cache.get(root);
        if (xy == null) {
            xy = new XY(getHeight(root.left), getHeight(root.right));
            cache.put(root, xy);
        }
        if (xy.left - xy.right < -1 || xy.left - xy.right > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    Map<TreeNode, XY> cache = new HashMap<>();

    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(treeNode.left), getHeight(treeNode.right));
    }


    @Test
    public void test() {

    }
}
