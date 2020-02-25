package src.designPattern.composite;

public class Main {
    public static void main(String[] args) {
        Box box = new Box("小推车");
        Component c1 = new Product("牙膏");
        Component c2 = new Product("肥皂");
        Component c3 = new Product("牙刷");
        Component c4 = new Product("洗衣粉");
        box.addProduct(c1);
        box.addProduct(c2);
        box.addProduct(c3);
        box.addProduct(c4);
        box.display();

    }
}
