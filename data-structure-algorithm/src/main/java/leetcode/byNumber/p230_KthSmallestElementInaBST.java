package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class p230_KthSmallestElementInaBST {

    @Test
    public void testKthSmallest() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode1.right = treeNode2;
        int i = kthSmallest(treeNode3, 3);
        System.out.println(i);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if (count == k) {
                return root.val;
            }
            if (stack.size() != 0) {
                stack.peek().left = null;
            }
            if (root.right != null) {
                stack.add(root.right);
            }
            root = stack.pop();
        }
    }

    public enum PurchasePayTypeEnums {
        WECHAT_PAY(new Integer(1), "微信支付"),
        UNDER_LINE_PAY(2, "线下支付");

        private Integer code;
        private String msg;

        public Integer getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        private PurchasePayTypeEnums(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public static PurchasePayTypeEnums getByCode(Integer code) {
            PurchasePayTypeEnums purchasePayTypeEnums = null;
            switch (code) {
                case 1:
                    purchasePayTypeEnums = WECHAT_PAY;
                    break;
                case 2:
                    purchasePayTypeEnums = UNDER_LINE_PAY;
            }

            return purchasePayTypeEnums;
        }
    }

    @Test
    public void test() {
        Integer integer = 1;
        System.out.println(integer.hashCode());
        System.out.println(PurchasePayTypeEnums.WECHAT_PAY.getCode().hashCode());
        System.out.println(new Integer(1));
        if (integer == PurchasePayTypeEnums.WECHAT_PAY.getCode()) {
            System.out.println("相等");
        }
        System.out.println(PurchasePayTypeEnums.WECHAT_PAY.getCode());
        System.out.println(integer == PurchasePayTypeEnums.WECHAT_PAY.getCode());
    }


    @Test
    public void testException() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            log.info("开始抛异常");
            throw new RuntimeException("异常");
        });
        voidCompletableFuture.get();
        log.info("消息发送完成");
        Thread.sleep(10000000);
    }
}
