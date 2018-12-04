package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

import java.util.PriorityQueue;

public class p23_MergekSortedLists {
    @Test
    public void test(){
        ListNode listNode = UtilListNode.fromArray(new int[]{1, 2, 3});
        ListNode listNode2 = UtilListNode.fromArray(new int[]{1, 1, 3});
        ListNode listNode3 = UtilListNode.fromArray(new int[]{1, 2, 4});
        System.out.println(mergeKLists(new ListNode[]{listNode, listNode2, listNode3}));
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] nodeLoc=new ListNode[lists.length];
        for(int i=0;i<lists.length;i++){
            nodeLoc[i]=new ListNode(0);
            nodeLoc[i].next=lists[i];
        }
        ListNode head=new ListNode(0);
        ListNode cur=head;
        while(true){
            ListNode maxNode = getMinNode(nodeLoc);
            if(maxNode==null)break;
            cur.next=maxNode.next;
            cur=cur.next;
            maxNode.next=maxNode.next.next;
        }
        return head.next;
    }
    public ListNode getMinNode(ListNode[] listNodes){
        ListNode maxNode=null;
        int max=Integer.MAX_VALUE;
        for (ListNode listNode : listNodes) {
            if(listNode.next!=null&&max>listNode.next.val){
                maxNode=listNode;
                max=listNode.next.val;
            }
        }
        return maxNode;
    }
}
