package leetcode;

import leetcode.base.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p98_ValidateBinarySearchTree_我的复杂版本 {
    class ChildValue {
        public long leftMax;
        public long rightMin;

        public ChildValue(long max, long min) {
            this.leftMax = max;
            this.rightMin = min;
        }

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ChildValue childValue = cache.get(root);
        if (childValue != null) {
            return root.val > childValue.leftMax && root.val < childValue.rightMin && isValidBST(root.left) && isValidBST(root.right);
        }
        long leftValue = getMaxValue(root.left);
        long rightValue = getMinValue(root.right);
        cache.put(root, new ChildValue(leftValue, rightValue));
        return root.val > leftValue && root.val < rightValue && isValidBST(root.left) && isValidBST(root.right);
    }

    private Map<TreeNode, ChildValue> cache = new HashMap<>();

    public long getMaxValue(TreeNode treeNode) {
        if (treeNode == null) {
            return Long.MIN_VALUE;
        }
        return Math.max(getMaxValue(treeNode.right), Math.max(treeNode.val, getMaxValue(treeNode.left)));
    }

    public long getMinValue(TreeNode treeNode) {
        if (treeNode == null) {
            return Long.MAX_VALUE;
        }
        return Math.min(getMinValue(treeNode.right), Math.min(treeNode.val, getMinValue(treeNode.left)));
    }

    @Test
    public void test() {

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        System.out.println(isValidBST(treeNode2));


    }

    @Test
    public void testMap() {
        Map<TreeNode, Integer> cache = new HashMap<>();
        TreeNode treeNode = new TreeNode(2);
        cache.put(treeNode, 2);
        cache.put(treeNode, 3);
        System.out.println(cache);

    }
}
