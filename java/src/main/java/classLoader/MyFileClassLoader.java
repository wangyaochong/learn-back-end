package classLoader;

import java.io.*;

public class MyFileClassLoader extends ClassLoader {
    private String directory;

    public MyFileClassLoader(String directory) {
        this.directory = directory;
    }

    public MyFileClassLoader(String directory, ClassLoader parent) {
        super(parent);
        this.directory = directory;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String file = directory + File.separator + name.replace(".", File.separator) + ".class";
        try {
            InputStream in = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = in.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            byte[] data = baos.toByteArray();
            in.close();
            baos.close();
            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyFileClassLoader classLoader = new MyFileClassLoader("D:/");
        Class<?> aClass = classLoader.loadClass("classLoader.Demo");
        aClass.newInstance();
    }
}
