package leetcode;

import leetcode.base.TreeLinkNode;
import org.junit.Test;


public class p117_递归待完成 {

    TreeLinkNode pre = null;

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connect(root.left);
        connect(root.right);
        if (root.left == null) {
            if (pre != null) {
                pre.next = root.right;
            }
        } else {
            root.left.next = root.right;
        }
        pre = root.right;

    }

    @Test
    public void test() {
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        TreeLinkNode treeLinkNode2 = new TreeLinkNode(2);
        TreeLinkNode treeLinkNode3 = new TreeLinkNode(3);
        treeLinkNode.left = treeLinkNode2;
        treeLinkNode.right = treeLinkNode3;
        connect(treeLinkNode);
        System.out.println(treeLinkNode);

    }
}
