package basic.test;

import org.junit.Test;

public class TestTryCatchFinally {
    @Test
    public void testTryFinally() {
        try {
            try {
                throw new RuntimeException("这是运行时异常");
            } finally {
                System.out.println("finally");
            }
        } catch (Exception e) {
            System.out.println("外层捕获异常");
        }
    }
}
