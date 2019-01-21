package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p297_SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                stringBuilder.append("n,");
            } else {
                stringBuilder.append(poll.val).append(",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] split = data.split(",");
        Integer[] integers = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("n")) {
                integers[i] = null;
                continue;
            }
            if (!split[i].equals("")) {
                integers[i] = Integer.parseInt(split[i]);
            }
        }
        return buildFromArray(integers);
    }

    public TreeNode buildFromArray(Integer[] array) {
        int loc = 0;
        TreeNode treeNode = new TreeNode(array[loc]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer left = array[++loc];
            Integer right = array[++loc];
            if (left == null) {
                poll.left = null;
            } else {
                poll.left = new TreeNode(left);
                queue.offer(poll.left);
            }
            if (right == null) {
                poll.right = null;
            } else {
                poll.right = new TreeNode(right);
                queue.offer(poll.right);
            }
        }
        return treeNode;
    }

    @Test
    public void testSerialize() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t2.left = t6;
        System.out.println(serialize(t1));
    }

    @Test
    public void testSerialize2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t2.left = t3;
        System.out.println(serialize(t1));
    }

    @Test
    public void testSerialize3() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.right = t3;
        System.out.println(serialize(t1));
    }


    @Test
    public void testDeserialize() {
        TreeNode deserialize = deserialize("1,null,2,null,3,null,null,");
        System.out.println(deserialize);
    }

    @Test
    public void testList() {
        List<Integer> list = Arrays.asList(1, null, 2, null, 3, null, null);
    }
}
