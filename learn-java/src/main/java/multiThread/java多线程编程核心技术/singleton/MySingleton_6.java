package multiThread.java多线程编程核心技术.singleton;

import java.io.*;

public class MySingleton_6 implements Serializable {//内部类实现方法，这种实现方式需要注意序列化的问题

    static class ObjectHolder {
        static MySingleton_6 object = new MySingleton_6();
    }

    public synchronized static MySingleton_6 getSingleton() {
        return ObjectHolder.object;
    }

    Object readResolve() throws ObjectStreamException {
        return ObjectHolder.object;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MySingleton_6 obj = MySingleton_6.getSingleton();
        FileOutputStream outputStream = new FileOutputStream(new File("test.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        outputStream.close();
        System.out.println(obj.hashCode());

        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(o.hashCode());
        System.out.println("线程状态" + Thread.currentThread().getState());
    }
}
