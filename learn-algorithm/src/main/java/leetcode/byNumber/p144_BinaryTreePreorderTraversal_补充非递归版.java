package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p144_BinaryTreePreorderTraversal_补充非递归版 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        travel(root, integers);
        return integers;
    }

    public void travel(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        result.add(node.val);
        travel(node.left, result);
        travel(node.right, result);
    }

    @Test
    public void test() {
    }
}
