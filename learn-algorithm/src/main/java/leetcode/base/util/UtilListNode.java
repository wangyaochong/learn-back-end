package leetcode.base.util;

import leetcode.base.definition.ListNode;
import org.junit.Test;

public class UtilListNode {

    public static ListNode fromArray(int[] input){
        ListNode listNode=new ListNode(0);
        ListNode cur=listNode;
        for(int i=0;i<input.length;i++){
            cur.next=new ListNode(input[i]);
            cur=cur.next;
        }
        return listNode.next;
    }

    @Test
    public void test(){
        System.out.println(fromArray(new int[]{1,2,3}));
    }
}
