package grammer.defaultKeyword;

public class DefaultInterfaceImpl implements DefaultInterface{

//
//    @Override
//    public void methodDefault() {
//        System.out.println("methodDefault in impl");
//    }

    @Override
    public void methodNoDefault() {
        System.out.println("methodNoDefault in impl");
    }

    public static void main(String[] args) {
        DefaultInterfaceImpl defaultInterface = new DefaultInterfaceImpl();
        defaultInterface.methodDefault();
        defaultInterface.methodNoDefault();
    }
}
