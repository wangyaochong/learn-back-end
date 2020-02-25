package src.designPattern.strategy;

public class Context {
    private AbstractStrategy abstractStrategy;

    public Context(AbstractStrategy abstractStrategy) {
        this.abstractStrategy = abstractStrategy;
    }

    public void execute(int x, int y) {
        int calc = this.abstractStrategy.calc(x, y);
        System.out.println(calc);
    }
}
