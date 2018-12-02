package leetcode.byNumber;

import leetcode.base.definition.RandomListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p138_CopyListwithRandomPointer {

    Map<Integer, RandomListNode> cache = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode randomListNode = new RandomListNode(head.label);
        cache.put(randomListNode.label, randomListNode);
        if (head.next != null) {
            RandomListNode next = cache.get(head.next.label);
            if (next == null) {
                randomListNode.next = copyRandomList(head.next);
            } else {
                randomListNode.next = next;
            }
        }
        if (head.random != null) {
            RandomListNode next = cache.get(head.random.label);
            if (next == null) {
                randomListNode.random = copyRandomList(head.random);
            } else {
                randomListNode.random = next;
            }
        }
        return randomListNode;
    }

    @Test
    public void test() {

    }
}
