package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        while (queue.size() != 1) {//只剩null标记
            TreeNode remove = queue.remove(0);
            if (remove == null) {
                result.add(new ArrayList<>(tmpResult));
                tmpResult.clear();
                queue.add(null);
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
        result.add(tmpResult);
        return result;
    }

    @Test
    public void test() {

    }
}
