package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class p230_KthSmallestElementInaBST {

    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        int tmp = 0;
        while (count < k) {
            TreeNode poll = queue.poll();
            while (poll != null) {
                queue.offer(poll);
                poll = poll.left;
            }
            count++;
            if (k == count) {
                return tmp;
            }
        }
        return 0;
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
