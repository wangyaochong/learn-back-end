package src.designPattern.strategy;

public class Sub implements AbstractStrategy {
    @Override
    public int calc(int x, int y) {
        return x - y;
    }
}
