package leetcode;

import leetcode.base.TreeLinkNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class p116_PopulatingNextRightPointersinEachNode_层序遍历 {


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
