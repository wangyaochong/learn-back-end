package structure.tree.treenode;

import leetcode.base.definition.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeightTreeNode extends TreeNode {
    Integer height;

    public HeightTreeNode(int x, TreeNode left, TreeNode right) {
        super(x, left, right);
    }

    public HeightTreeNode(int x) {
        super(x);
    }

    public static int getHeight(HeightTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }
}
