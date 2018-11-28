package leetcode;

import leetcode.base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p95_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return getResult(1, n);
    }

    public List<TreeNode> getResult(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = getResult(start, i - 1);
            List<TreeNode> rightNodes = getResult(i + 1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(generateTrees(3));
    }
}
