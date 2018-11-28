package leetcode;

import leetcode.base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getResult(root, result);
        return result;
    }

    public void getResult(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        getResult(root.left, result);
        result.add(root.val);
        getResult(root.right, result);
    }

    @Test
    public void test() {

    }
}
