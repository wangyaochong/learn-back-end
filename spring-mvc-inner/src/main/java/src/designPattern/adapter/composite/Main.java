package src.designPattern.adapter.composite;

public class Main {
    public static void main(String[] args) {
        Adapter adapter = new AdapterImpl(new AdapteeClass());
        adapter.handle();
    }
}
