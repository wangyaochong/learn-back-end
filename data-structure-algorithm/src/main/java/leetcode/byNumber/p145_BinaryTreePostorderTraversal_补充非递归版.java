package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p145_BinaryTreePostorderTraversal_补充非递归版 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        travel(root, result);
        return result;
    }

    public void travel(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        travel(node.left, result);
        travel(node.right, result);
        result.add(node.val);
    }

    @Test
    public void test() {

    }
}
