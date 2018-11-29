package leetcode;

import leetcode.base.TreeLinkNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 这个和第一个的条件有变化，不是完全二叉树，所以可以用层序遍历
 */
public class p117_PopulatingNextRightPointersinEachNodeII_层序遍历 {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        List<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() != 1) {
            TreeLinkNode remove = queue.remove(0);
            if (remove != null) {
                remove.next = queue.get(0);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            } else {
                queue.add(null);
            }
        }
    }
}
