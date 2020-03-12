package structure.tree.treenode;

import leetcode.base.definition.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WeightTreeNode extends TreeNode {
    Integer weight;
}
