package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p105_ConstructBinaryTreeFromPreorderAndInorderTraversal_加个缓存吧 {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderLocCache = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderLocCache.put(inOrder[i], i);
        }
        return buildNode(preOrder, 0, 0, preOrder.length - 1, inOrderLocCache);
    }

    public TreeNode buildNode(int[] preOrder, int preIndex, int inStart, int inEnd, Map<Integer, Integer> inOrderLocCache) {
        if (inStart > inEnd || preIndex >= preOrder.length) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preOrder[preIndex]);
        int inIndex = inOrderLocCache.get(preOrder[preIndex]);
        //对于左边的，就直接使用下一个根节点即可
        treeNode.left = buildNode(preOrder, preIndex + 1, inStart, inIndex - 1, inOrderLocCache);
        //对于右边子树，则从要从根节点跳过左子树长度，选择右子树的根节点
        treeNode.right = buildNode(preOrder, preIndex + 1 + inIndex - inStart, inIndex + 1, inEnd, inOrderLocCache);
        return treeNode;
    }

    @Test
    public void test() {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
