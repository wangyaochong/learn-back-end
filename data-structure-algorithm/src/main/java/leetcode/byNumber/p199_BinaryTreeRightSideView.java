package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        getResult(root, 0);
        return result;
    }

    List<Integer> result = new ArrayList<>();
    int[] levelFlag = new int[1000];

    public void getResult(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (levelFlag[level] == 0) {
            result.add(root.val);
            levelFlag[level] = 1;
        }
        getResult(root.right, level + 1);
        getResult(root.left, level + 1);
    }


    @Test
    public void test() {

    }
}
