package grammer.interfacesWithSameMethod;

public class Monster implements Cat,Dog {
    @Override
    public void catchMouse() {
        System.out.println("monster catchMouse");
    }

    @Override
    public void run() {
        System.out.println("monster run");
    }

    @Override
    public void eat() {
        System.out.println("monster eat");
    }

    @Override
    public void shakeTail() {
        System.out.println("monster shakeTail");
    }

    public static void main(String[] args) {
        Monster monster=new Monster();
        monster.run();
        monster.catchMouse();
        monster.eat();
        monster.shakeTail();
    }
}
