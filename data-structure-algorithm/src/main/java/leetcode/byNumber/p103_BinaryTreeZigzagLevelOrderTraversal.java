package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class p103_BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        int count = 0;
        while (queue.size() != 1) {//只剩null标记
            TreeNode remove;
            remove = queue.remove(0);
            if (remove == null) {
                if (count % 2 == 1) {
                    Collections.reverse(tmpResult);
                }
                result.add(new ArrayList<>(tmpResult));
                tmpResult.clear();
                queue.add(null);
                count++;
            } else {
                tmpResult.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
        }
        if (count % 2 == 1) {
            Collections.reverse(tmpResult);
        }
        result.add(tmpResult);
        return result;
    }

    @Test
    public void test() {

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        System.out.println(zigzagLevelOrder(treeNode2));

    }
}
