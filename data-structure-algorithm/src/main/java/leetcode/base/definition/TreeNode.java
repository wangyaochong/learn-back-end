package leetcode.base.definition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public Integer weight;
    public boolean isLeftIndex;
    public boolean isRightIndex;

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
    public TreeNode(int x) {
        this.val = x;
        this.weight = x;
    }
}
