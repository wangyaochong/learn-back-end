package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p236_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getPath(root, p, q, new ArrayList<>());
        int i = 0;
        int j = 0;
        while (i < pPath.size() && j < qPath.size() && pPath.get(i) == qPath.get(j)) {
            i++;
            j++;
        }
        return pPath.get(i - 1);
    }

    List<TreeNode> pPath;
    List<TreeNode> qPath;

    public void getPath(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> tmpPath) {
        if (root == null || (qPath != null && pPath != null)) {
            return;
        }
        tmpPath.add(root);
        if (p == root) {
            pPath = new ArrayList<>(tmpPath);
        }
        if (q == root) {
            qPath = new ArrayList<>(tmpPath);
        }
        getPath(root.left, p, q, tmpPath);
        getPath(root.right, p, q, tmpPath);
        tmpPath.remove(tmpPath.size() - 1);
    }

    @Test
    public void test() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        System.out.println(lowestCommonAncestor(a, b, a));
    }
}
