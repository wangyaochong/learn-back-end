package src.designPattern.strategy;

public class Add implements AbstractStrategy {
    @Override
    public int calc(int x, int y) {
        return x + y;
    }
}
