package src.designPattern.strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new Add());
        context.execute(1, 2);
        context = new Context(new Sub());
        context.execute(1, 2);
    }
}
