package structure.tree;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraverseTreeNoRecursion {
    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(5, new TreeNode(6, new TreeNode(8, null, null), null), new TreeNode(7, null, null)));
        System.out.println("层序遍历--------------");
        levelOrder(treeNode);
//        System.out.println("没有递归的先序遍历");
//        preOrderNoRecursion(treeNode);
        System.out.println("没有递归的中序遍历");
        inOrderNoRecursion(treeNode);
//        System.out.println("没有递归的后序遍历---------");
//        postOrderNoRecursion(treeNode);//会改动数据
    }

    public void levelOrder(TreeNode treeNode) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove(0);
            System.out.println(remove.getVal());
            if (remove.getLeft() != null) {
                queue.add(remove.getLeft());
            }
            if (remove.getRight() != null) {
                queue.add(remove.getRight());
            }
        }
    }

    public void levelOrderFormat(TreeNode treeNode) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(treeNode);
        queue.add(null);
        while (queue.size() > 1) {
            TreeNode remove = queue.remove(0);
            if (remove == null) {
                System.out.println("\n---------------------------------");
                queue.add(null);
            } else {
                System.out.print(remove.getVal() + "  ");
                if (remove.getLeft() != null) {
                    queue.add(remove.getLeft());
                }
                if (remove.getRight() != null) {
                    queue.add(remove.getRight());
                }
            }
        }
    }

    public void preOrderNoRecursion(TreeNode treeNode) {
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(treeNode);
        while (!nodeStack.isEmpty()) {
            TreeNode pop = nodeStack.peek();
            if (pop.getVal() != null) {
                System.out.println(pop.getVal());
            }
            pop.setVal(null);
            if (pop.getLeft() != null) {
                nodeStack.add(pop.getLeft());
                pop.setLeft(null);
            } else if (pop.getRight() != null) {
                nodeStack.add(pop.getRight());
                pop.setRight(null);
            } else {
                nodeStack.pop();
            }
        }
    }

    public void inOrderNoRecursion(TreeNode treeNode) {
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(treeNode);
        while (!nodeStack.isEmpty()) {
            TreeNode pop = nodeStack.peek();
            if (pop.getLeft() == null) {
                System.out.println(pop.getVal());
                nodeStack.pop();//看过一次以后就要拿出来
                if (pop.getRight() != null) {
                    nodeStack.push(pop.getRight());
                }
            }
            if (pop.getLeft() != null) {
                nodeStack.add(pop.getLeft());
                pop.setLeft(null);
            }
        }
    }

    public void postOrderNoRecursion(TreeNode treeNode) {
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(treeNode);
        while (!nodeStack.isEmpty()) {
            TreeNode pop = nodeStack.peek();
            if (pop.getLeft() != null) {
                nodeStack.add(pop.getLeft());
                pop.setLeft(null);
            } else if (pop.getRight() != null) {
                nodeStack.add(pop.getRight());
                pop.setRight(null);
            } else {
                System.out.println(pop.getVal());
                nodeStack.pop();
            }
        }
    }
}
