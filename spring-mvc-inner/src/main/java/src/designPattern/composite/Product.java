package src.designPattern.composite;

public class Product extends Component {
    public Product(String name) {
        super(name);
    }

    @Override
    protected void display() {
        System.out.println("the of product is " + getName());
    }
}
