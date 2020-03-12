package structure.tree;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HuffmanTree {
    public TreeNode build(List<TreeNode> nodeList) {
        //先要排序
        nodeList.sort(Comparator.comparingInt(o -> o.weight));
        while (nodeList.size() >= 2) {
            TreeNode a = nodeList.remove(0);
            TreeNode b = nodeList.remove(0);
            TreeNode newNode = new TreeNode(a.weight + b.weight);
            newNode.left = a;
            newNode.right = b;
            int i = 0;
            //找到合适的位置，插入新的节点
            while (i < nodeList.size() && newNode.getWeight() > nodeList.get(i).getWeight()) i++;
            nodeList.add(i, newNode);
        }
        return nodeList.remove(0);
    }


    @Test
    public void testBuild() {
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(new TreeNode(13));
        nodeList.add(new TreeNode(7));
        nodeList.add(new TreeNode(8));
        nodeList.add(new TreeNode(3));
        nodeList.add(new TreeNode(29));
        nodeList.add(new TreeNode(6));
        nodeList.add(new TreeNode(1));
        TreeNode build = build(nodeList);
        TraverseTreeNoRecursion traverseTreeNoRecursion = new TraverseTreeNoRecursion();
        traverseTreeNoRecursion.levelOrderFormat(build);
    }
}
