package src.designPattern.dynamicRroxy.jdk;

public class TargetImpl implements Target {
    @Override
    public void handle() {
        System.out.println("handle executed");
    }
}
