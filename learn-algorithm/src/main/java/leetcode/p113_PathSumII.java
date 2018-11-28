package leetcode;

import leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class p113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(root, sum, new ArrayList<>(), result);
        return result;
    }

    public void getResult(TreeNode node, int sum, List<Integer> tmpResult, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && node.val == sum) {
            tmpResult.add(node.val);
            result.add(new ArrayList<>(tmpResult));
            tmpResult.remove(tmpResult.size() - 1);
        }
        tmpResult.add(node.val);
        getResult(node.left, sum - node.val, tmpResult, result);
        getResult(node.right, sum - node.val, tmpResult, result);
        tmpResult.remove(tmpResult.size() - 1);
    }
}
