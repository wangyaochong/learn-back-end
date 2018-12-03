package java8.lambda;

import org.junit.Test;

public class TestLambda {

    @FunctionalInterface
    interface AnyMethod {
        void execute();
    }

    class LockService {
        public void executeInLock(AnyMethod method) {
            try {
                System.out.println("尝试获取锁");
                method.execute();
            } catch (Exception e) {
                System.out.println("未获取到锁");
            } finally {
                System.out.println("释放锁");
            }
        }
    }

    @Test
    public void test() {
        LockService lockService = new LockService();
        lockService.executeInLock(() -> {
            anyMethod("test", 123);
        });
    }

    public void anyMethod(String name, Integer age) {
        System.out.println(String.format("name=%s,age=%s", name, age));
    }

}
