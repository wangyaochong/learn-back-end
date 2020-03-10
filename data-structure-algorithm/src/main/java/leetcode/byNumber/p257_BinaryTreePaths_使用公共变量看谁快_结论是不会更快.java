package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p257_BinaryTreePaths_使用公共变量看谁快_结论是不会更快 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        getResult(new char[100], (byte) 0, root);
        return result;
    }

    List<String> result = new ArrayList<>();

    public void getResult(char[] buffer, byte len, TreeNode root) {
        if (root == null) {
            return;
        }
        String s = String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            for (int i = 0; i < s.length(); i++) {
                buffer[len++] = s.charAt(i);
            }
            result.add(new String(buffer, 0, len));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            buffer[len++] = s.charAt(i);
        }
        buffer[len++] = '-';
        buffer[len++] = '>';
        getResult(buffer, len, root.left);
        getResult(buffer, len, root.right);

    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode.left = treeNode2;
        System.out.println(binaryTreePaths(treeNode));
    }

    @Test
    public void testByte() {
    }
}
