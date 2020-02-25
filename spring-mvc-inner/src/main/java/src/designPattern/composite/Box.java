package src.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Box extends Component {
    private List<Component> productList = new ArrayList<>();

    public Box(String name) {
        super(name);
    }

    @Override
    protected void display() {
        for (Component component : productList) {
            component.display();
        }
    }

    public void addProduct(Component component) {
        productList.add(component);
    }

    public void remove(Component component) {
        productList.remove(component);
    }
}
