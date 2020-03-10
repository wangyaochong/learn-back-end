package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void test() {

    }
}
