package src.designPattern.composite;

public abstract class Component {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Component(String name) {
        this.name = name;
    }

    protected abstract void display();
}
