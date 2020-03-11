package grammer.defaultKeyword;

public interface DefaultInterface {
    default void methodDefault() {
        System.out.println("default method in interface");
    }

    void methodNoDefault();
}
