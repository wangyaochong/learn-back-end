package src.designPattern.dynamicProxy.jdk;

public class TargetImpl implements Target {
    @Override
    public void handle() {
        System.out.println("handle executed");
    }
}
