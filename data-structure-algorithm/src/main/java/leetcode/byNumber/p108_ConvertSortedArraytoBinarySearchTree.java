package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildOne(nums, 0, nums.length - 1);
    }

    public TreeNode buildOne(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = buildOne(nums, start, mid - 1);
        treeNode.right = buildOne(nums, mid + 1, end);
        return treeNode;
    }

    @Test
    public void test() {
        System.out.println(sortedArrayToBST(new int[]{1, 2, 3, 4, 5}));
    }
}
