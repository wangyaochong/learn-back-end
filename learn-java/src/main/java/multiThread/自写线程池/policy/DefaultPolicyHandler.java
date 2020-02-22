package multiThread.自写线程池.policy;

import multiThread.自写线程池.MyExecutorService;
import multiThread.自写线程池.PolicyException;

public class DefaultPolicyHandler implements PolicyHandler {
    @Override
    public void rejected(Runnable task, MyExecutorService executorService) {
        String errorMsg = "任务已经满了";
        System.out.println(errorMsg);
        throw new PolicyException(errorMsg);
    }
}
