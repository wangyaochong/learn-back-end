package collection;

public class MyArrayList<T> {
    T[] list;

    public MyArrayList(int size) {

        //list = new T[size]; 会提示type parameter cannot be instantiated directly
        //因为泛型无法直接初始化，所以jdk的ArrayList只能使用使用Object[]保存数据
    }
}
