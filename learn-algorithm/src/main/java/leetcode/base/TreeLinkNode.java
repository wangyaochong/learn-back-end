package leetcode.base;

import lombok.Data;

@Data
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
        val = x;
    }
}
