package proxy.base;

public class Target implements ITarget {
    @Override
    public void targetMethod(String param) {
        System.out.println("Target.targetMethod param=".concat(param));
    }
}
