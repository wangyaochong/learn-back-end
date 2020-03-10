package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p106_ConstructBinaryTreeFromInorderAndPostorderTraversal_不错 {


    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> inOrderLocCache = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderLocCache.put(inOrder[i], i);
        }
        return buildNode(postOrder, postOrder.length - 1, 0, inOrder.length - 1, inOrderLocCache);
    }

    public TreeNode buildNode(int[] postOrder, int postIndex, int inStart, int inEnd, Map<Integer, Integer> inOrderLocCache) {
        if (inStart > inEnd || postIndex < 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postOrder[postIndex]);
        int inIndex = inOrderLocCache.get(postOrder[postIndex]);
        //由于后续遍历，所以从后往前依次是根节点，
        treeNode.right = buildNode(postOrder, postIndex - 1, inIndex + 1, inEnd, inOrderLocCache);
        treeNode.left = buildNode(postOrder, postIndex - 1 - (inEnd - inIndex), inStart, inIndex - 1, inOrderLocCache);
        return treeNode;
    }

    @Test
    public void test() {
        TreeNode treeNode = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
