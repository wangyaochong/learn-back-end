package structure.tree;
import leetcode.base.definition.TreeNode;
import org.junit.Test;
//3
//2
//4
//1
//8
//6
//5
//7

/**
 * --------1
 * ---2        5
 * 3    4     6   7
 * ----------8
 */
public class TraverseTreeRecursion {


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(5, new TreeNode(6, new TreeNode(8, null, null), null), new TreeNode(7, null, null)));

        System.out.println("先序----------------");
        preOrder(treeNode);
        System.out.println("中序--------------");
        inOrder(treeNode);
        System.out.println("后序------------");
        postOrder(treeNode);


    }

    public void postOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        visit(treeNode);
    }

    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        if (!treeNode.isLeftIndex())
        inOrder(treeNode.getLeft());
        visit(treeNode);
        if (!treeNode.isRightIndex())
        inOrder(treeNode.getRight());
    }

    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        visit(treeNode);
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }


    public void visit(TreeNode treeNode) {
        System.out.println(treeNode.getVal() + "," + treeNode.getWeight());
    }
}
