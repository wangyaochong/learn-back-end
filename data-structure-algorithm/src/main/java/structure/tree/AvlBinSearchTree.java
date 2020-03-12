package structure.tree;

import org.junit.Test;
import structure.tree.treenode.HeightTreeNode;

import java.util.Stack;

public class AvlBinSearchTree {

    public HeightTreeNode head;


    public HeightTreeNode rightRotate(HeightTreeNode node) {
        //左子节点晋升
        HeightTreeNode left = (HeightTreeNode) node.getLeft();
        //如果发现左子节点的右子节点更长，则需要先左旋
        if (HeightTreeNode.getHeight((HeightTreeNode) left.getRight()) > HeightTreeNode.getHeight((HeightTreeNode) left.getLeft())) {
            left = leftRotate(left);
        }
        node.setHeight(HeightTreeNode.getHeight((HeightTreeNode) node.getRight()) + 1);
        HeightTreeNode newTop = new HeightTreeNode();
        newTop.setVal(left.getVal());
        newTop.setRight(node);
        newTop.setLeft(left.getLeft());
        newTop.setHeight(HeightTreeNode.getHeight((HeightTreeNode) left.getLeft()) + 1);
        node.setLeft(left.getRight());
        return newTop;
    }

    public HeightTreeNode leftRotate(HeightTreeNode node) {
        //如果发现右子节点的左子节点更长，则需要先右旋
        HeightTreeNode right = (HeightTreeNode) node.getRight();
        if (HeightTreeNode.getHeight((HeightTreeNode) right.getRight()) < HeightTreeNode.getHeight((HeightTreeNode) right.getLeft())) {
            right = rightRotate(right);
        }
        node.setHeight(HeightTreeNode.getHeight((HeightTreeNode) node.getLeft()) + 1);
        HeightTreeNode newTop = new HeightTreeNode();
        newTop.setVal(right.getVal());
        newTop.setLeft(node);
        newTop.setRight(right.getRight());
        newTop.setHeight(HeightTreeNode.getHeight((HeightTreeNode) right.getRight()) + 1);
        node.setRight(right.getLeft());
        return newTop;
    }

    public void insert(HeightTreeNode val) {
        val.setHeight(1);
        //如果是空，直接插入，否则就下沉
        if (head == null) {
            head = val;
            head.setHeight(1);
        } else {
            HeightTreeNode tmp = head;
            //记录插入走过的路径，更新树的高度时会用到
            Stack<HeightTreeNode> path = new Stack<>();

            //插入节点，并更新插入位置的高度
            while (true) {
                while (val.getVal() >= tmp.getVal() && tmp.getRight() != null) {
                    path.push(tmp);
                    tmp = (HeightTreeNode) tmp.getRight();
                }
                while (val.getVal() < tmp.getVal() && tmp.getLeft() != null) {
                    path.push(tmp);
                    tmp = (HeightTreeNode) tmp.getLeft();
                }
                if (val.getVal() >= tmp.getVal() && tmp.getRight() == null) {
                    //不管有没有左节点，有了一个左子树，高度就变了
                    tmp.setRight(val);
                    if (tmp.getLeft() == null) {
                        tmp.setHeight(2);
                    } else {
                        tmp.setHeight(Math.max(2, ((HeightTreeNode) tmp.getLeft()).getHeight() + 1));
                    }
                    break;
                }
                if (val.getVal() < tmp.getVal() && tmp.getLeft() == null) {
                    tmp.setLeft(val);
                    if (tmp.getRight() == null) {
                        tmp.setHeight(2);
                    } else {
                        tmp.setHeight(Math.max(2, ((HeightTreeNode) tmp.getRight()).getHeight() + 1));
                    }
                    break;
                }
            }

            //更新高度，找到不平衡的节点
            while (!path.isEmpty()) {
                HeightTreeNode pop = path.pop();
                int leftHeight;
                int rightHeight;
                if (pop.getLeft() == null && pop.getRight() == null) {
                    pop.setHeight(1);
                    leftHeight = 0;
                    rightHeight = 0;
                } else if (pop.getLeft() != null && pop.getRight() == null) {
                    pop.setHeight(((HeightTreeNode) pop.getLeft()).getHeight() + 1);
                    rightHeight = 0;
                    leftHeight = ((HeightTreeNode) pop.getLeft()).getHeight();
                } else if (pop.getLeft() == null && pop.getRight() != null) {
                    pop.setHeight(((HeightTreeNode) pop.getRight()).getHeight() + 1);
                    leftHeight = 0;
                    rightHeight = ((HeightTreeNode) pop.getRight()).getHeight();
                } else {
                    pop.setHeight(Math.max(((HeightTreeNode) pop.getLeft()).getHeight(), ((HeightTreeNode) pop.getRight()).getHeight()) + 1);
                    leftHeight = ((HeightTreeNode) pop.getLeft()).getHeight();
                    rightHeight = ((HeightTreeNode) pop.getRight()).getHeight();
                }
                if (leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1) {
                    HeightTreeNode newNode = null;
                    if (leftHeight - rightHeight > 1) {
                        newNode = rightRotate(pop);
                    } else {
                        newNode = leftRotate(pop);
                    }
                    HeightTreeNode parent = null;
                    if (path.size() != 0) {
                        parent = path.peek();
                    }
                    if (parent == null) {
                        head = newNode;
                    }
                    if (parent != null && parent.getLeft() == pop) {
                        parent.setLeft(newNode);
                    }
                    if (parent != null && parent.getRight() == pop) {
                        parent.setRight(newNode);
                    }
                    //调整结束就可以跳出循环了
                    break;
                }
            }

        }
    }

    public int getHeight(HeightTreeNode node) {
        if (node == null) {
            return 0;
        }
        node.setHeight(Math.max(getHeight((HeightTreeNode) node.getLeft()), getHeight((HeightTreeNode) node.getRight())) + 1);
        return node.getHeight();
    }

    @Test
    public void testInsert() {
        insert(new HeightTreeNode(5));
        insert(new HeightTreeNode(6));
        insert(new HeightTreeNode(2));
        insert(new HeightTreeNode(1));
        insert(new HeightTreeNode(3));
        insert(new HeightTreeNode(4));
        System.out.println(this);
        new TraverseTreeRecursion().inOrder(head);
    }

    @Test
    public void test() {
        HeightTreeNode treeNode = new HeightTreeNode(1,
                new HeightTreeNode(2, new HeightTreeNode(3, null, null), new HeightTreeNode(4, null, null)),
                new HeightTreeNode(5, new HeightTreeNode(6, new HeightTreeNode(8, null, null), null), new HeightTreeNode(7, null, null)));
        System.out.println(getHeight(treeNode));
    }

}
