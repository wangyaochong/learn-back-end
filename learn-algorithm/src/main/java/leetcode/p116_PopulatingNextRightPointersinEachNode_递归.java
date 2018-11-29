package leetcode;

import leetcode.base.TreeLinkNode;
import org.junit.Test;

public class p116_PopulatingNextRightPointersinEachNode_递归 {


    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.right);
        connect(root.left);
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
