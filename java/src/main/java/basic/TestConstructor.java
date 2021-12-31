package basic;

public class TestConstructor {
    public TestConstructor() {
        System.out.println("public TestConstructor");
    }
    public void TestConstructor(){
        System.out.println("public void TestConstructor");
    }

    public static void main(String[] args) {
        TestConstructor obj = new TestConstructor();
    }
}
